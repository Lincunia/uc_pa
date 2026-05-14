package gui.nlp;

import java.util.Arrays;
import java.util.List;

public class Model
{
    private Tokenizer tokenizer;
    private ResponseGenerator responseGenerator;
    private Parser parser;
    private Controller controller;

    public Model (Controller controller)
    {
        this.controller = controller;
        tokenizer = new Tokenizer ();
        parser = new Parser ();
        responseGenerator = new ResponseGenerator ();

        loadFiles ();
    }

    public void
    loadFiles ()
    {
        try
            {
                tokenizer.loadTokens ("tokens.txt");
                tokenizer.loadStopWords ("stopwords.txt");
                responseGenerator.loadData ("datos_productos.txt");
                parser.loadTable ("tabla_gramatica.txt");
            }
        catch (Exception e)
            {
                controller.displayMessage (e.getMessage ()
                                           + "\n\nArchivo inaccesible");
                System.exit (1);
            }
    }

    public List<String>
    tokenization (String entrada)
    {
        return Arrays.asList (entrada.toLowerCase ()
                                  .replaceAll ("[¿?]", "")
                                  .trim ()
                                  .split ("\\s+"));
    }

    public List<String>
    filterStopWords (List<String> palabras)
    {
        return tokenizer.filterStopWords (palabras);
    }

    public List<Token>
    lexicalAnalyzer (List<String> filteredWords)
    {
        return tokenizer.tokenizeString (filteredWords);
    }

    public String
    analyzeSyntactically (String tokens)
    {
        return parser.parse (tokens.trim ());
    }

    public String
    getParsingOutput ()
    {
        return (parser.getCheckState ()) ? " Cadena correcta "
                                         : " Cadena no válida ";
    }

    // Generar respuesta automática
    public String
    generateResponse (List<Token> analyzedTokens)
    {
        return (parser.getCheckState ())
            ? responseGenerator.generarRespuesta (analyzedTokens)
            : "Asegúrate primero de que esté bien escrita tu pregunta";
    }
}
