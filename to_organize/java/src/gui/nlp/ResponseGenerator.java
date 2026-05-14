package gui.nlp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseGenerator
{
    private Map<String, Map<String, String>> products;
    private BufferedReader reader;
    private String line, currentProduct, rareAction;
    private Knowledge knowledge;
    private Map<String, String> info;

    private List<String> prioritaryVerbs;

    public ResponseGenerator ()
    {
        products = new HashMap<> ();
        prioritaryVerbs = Arrays.asList (
            "cuesta", "cuestan", "vale", "valen", "compra", "pagar", "precio",
            "donde", "esta", "estan", "encuentra", "encuentran", "encuentro",
            "busco", "ubico", "hay", "queda", "venden", "vende", "ofrecen",
            "ofrece", "tiene", "tienen", "contiene", "incluye", "viene",
            "trae", "lleva");
    }

    public void
    loadData (String path) throws Exception
    {
        reader = new BufferedReader (new FileReader (path));
        currentProduct = null;
        while ((line = reader.readLine ()) != null)
            {
                if (line.startsWith ("#"))
                    {
                        currentProduct = line.substring (1).trim ();
                        products.put (currentProduct, new HashMap<> ());
                        continue;
                    }
                if (line.contains (":") && currentProduct != null)
                    {
                        String[] partes = line.split (":", 2);
                        products.get (currentProduct)
                            .put (partes[0].trim (), partes[1].trim ());
                    }
            }
        reader.close ();
    }

    public String
    generarRespuesta (List<Token> tokens)
    {
        knowledge = new Knowledge ();
        int cantidad = 1;
        String pos, lexema;

        for (Token t : tokens)
            {
                pos = t.getPos ();
                lexema = normalizeWord (t.getLexema ());

                if (pos.equals ("interrogativo")
                    && knowledge.getQuestion () == null)
                    {
                        knowledge.setQuestion (lexema);
                        continue;
                    }

                if (pos.equals ("producto") && knowledge.getProduct () == null)
                    {
                        knowledge.setProduct (lexema);
                        continue;
                    }

                if (pos.equals ("unidad") && knowledge.getUnity () == null)
                    {
                        knowledge.setUnity (singular (lexema));
                        continue;
                    }

                if (pos.equals ("adjetivo") && knowledge.getExtra () == null)
                    {
                        knowledge.setExtra (lexema);
                        continue;
                    }
                if (pos.equals ("numero") || lexema.matches ("\\d+"))
                    {
                        try
                            {
                                cantidad = convertirANumero (lexema);
                            }
                        catch (Exception e)
                            {
                                cantidad = 1;
                            }
                        continue;
                    }
                if (pos.equals ("verbo"))
                    {
                        rareAction = lexema;
                        if (knowledge.getVerb () == null
                            && prioritaryVerbs.contains (lexema))
                            {
                                knowledge.setVerb (lexema);
                                continue;
                            }
                    }
            }

        if (knowledge.getProduct () == null
            || !products.containsKey (normalizeWord (knowledge.getProduct ())))
            {
                return "Ese producto no se encuentra";
            }

        info = products.get (normalizeWord (knowledge.getProduct ()));

        // Marca
        for (Token token : tokens)
            {
                if (normalizeWord (token.getLexema ()).equals ("marca")
                    && knowledge.getProduct () != null
                    && products.containsKey (
                        normalizeWord (knowledge.getProduct ())))
                    {
                        return "La marca disponible de "
                            + knowledge.getProduct () + " es "
                            + info.getOrDefault ("marca", "desconocida");
                    }
            }

        if (knowledge.getQuestion () == null)
            knowledge.setQuestion ("");

        if (knowledge.getVerb () == null)
            return "No sé a qué te refieres con \"" + rareAction + "\"";

        // Precio
        if (knowledge.getVerb ().matches (
                "cuesta|cuestan|vale|valen|compra|pagar|precio")
            && knowledge.getQuestion ().matches ("cuanto|como"))
            {
                if (knowledge.getUnity () != null
                    && info.containsKey ("precio " + knowledge.getUnity ()))
                    {
                        return cantidad + " "
                            + pluralizar (knowledge.getUnity (), cantidad)
                            + " de " + knowledge.getProduct () + " "
                            + knowledge.getVerb () + " $ "
                            + Integer.parseInt (
                                  info.get ("precio " + knowledge.getUnity ()))
                                  * cantidad;
                    }
                else
                    {
                        return "No se encontró precio para la unidad indicada";
                    }
            }

        // Ubicación
        if (knowledge.getVerb ().matches (
                "esta|estan|encuentra|encuentro|busco|ubico|encuentran")
            && knowledge.getQuestion ().matches ("donde"))
            {
                return getDeterminer (knowledge.getProduct ()) + " está en "
                    + info.getOrDefault ("ubicacion",
                                         "ubicación no especificada");
            }

        // Disponibilidad
        if (knowledge.getVerb ().matches ("hay|tiene|tienen|disponible|queda|"
                                          + "venden|vende|ofrecen|ofrece")
            && knowledge.getQuestion ().matches ("(?:que\\s*)?"))
            {
                return info.getOrDefault ("stock", "no")
                           .equalsIgnoreCase ("sí")
                    ? "Sí, hay " + knowledge.getProduct () + " disponible."
                    : "No, actualmente no hay " + knowledge.getProduct ()
                          + " en stock";
            }

        // Marca (por si viene por knowledge.getVerb() "marca")
        if (knowledge.getVerb ().contains ("marca"))
            {
                return "La marca disponible de " + knowledge.getProduct ()
                    + " es " + info.getOrDefault ("marca", "desconocida");
            }

        // Contenido
        if (knowledge.getVerb ().matches (
                "tiene|contiene|incluye|viene|trae|lleva")
            || knowledge.getQuestion ().matches ("(?:que\\s*)?"))
            {
                if (knowledge.getExtra () != null
                    && info.containsKey (knowledge.getExtra ()))
                    {
                        return "Sí, " + getDeterminer (knowledge.getProduct ())
                            + " contiene " + knowledge.getExtra ();
                    }
                if (info.containsKey ("relleno"))
                    {
                        return getDeterminer (knowledge.getProduct ())
                            + " lleva " + info.get ("relleno");
                    }
                if (info.containsKey ("contenido"))
                    {
                        return getDeterminer (knowledge.getUnity () != null
                                                  ? knowledge.getUnity ()
                                                  : "presentación")
                            + " de " + knowledge.getProduct () + " contiene "
                            + info.get ("contenido");
                    }
                return "No se especifica contenido para este producto";
            }

        return "No se pudo generar una respuesta para esa pregunta";
    }

    private String
    getDeterminer (String word)
    {
        if (word.endsWith ("a") || word.endsWith ("ción"))
            return "La " + word;
        if (word.endsWith ("[eo]s"))
            return "Los " + word;
        if (word.endsWith ("as"))
            return "Las " + word;
        return "El " + word;
    }

    private String
    singular (String word)
    {
        if (word.endsWith ("ces"))
            return word.substring (0, word.length () - 3) + "z";
        if (word.endsWith ("nes"))
            return word.substring (0, word.length () - 2);
        if (word.endsWith ("s"))
            return word.substring (0, word.length () - 1);
        return word;
    }

    private String
    pluralizar (String word, int cantidad)
    {
        if (cantidad == 1)
            return word;
        if (word.endsWith ("z"))
            return word.substring (0, word.length () - 1) + "ces";
        return word + "s";
    }

    private int
    convertirANumero (String texto)
    {
        switch (texto.toLowerCase ())
            {
            case "uno":
            case "una":
                return 1;
            case "dos":
                return 2;
            case "tres":
                return 3;
            case "cuatro":
                return 4;
            case "cinco":
                return 5;
            case "seis":
                return 6;
            case "siete":
                return 7;
            case "ocho":
                return 8;
            case "nueve":
                return 9;
            case "diez":
                return 10;
            default:
                return Integer.parseInt (texto);
            }
    }

    private static String
    normalizeWord (String lexeme)
    {
        String ascii
            = Normalizer.normalize (lexeme, Normalizer.Form.NFD)
                  .replaceAll ("\\p{InCombiningDiacriticalMarks}+", "");
        return ascii.toLowerCase ().replaceAll ("[^a-z0-9 ]", "");
    }
}
