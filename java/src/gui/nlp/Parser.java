package gui.nlp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Parser
{
    private Map<String, Map<String, String>> tabla;
    private Stack<String> pila;
    private BufferedReader reader;
    private String line, output, top, currentToken, regla;
    private List<String> tokens;
    private Boolean checkState;
    private final String START_SYMBOL = "S";

    public Parser ()
    {
        tabla = new HashMap<> ();
        pila = new Stack<> ();
    }

    public void
    loadTable (String path) throws Exception
    {
        reader = new BufferedReader (new FileReader (path));
        while ((line = reader.readLine ()) != null)
            {
                if (!line.trim ().isEmpty () && line.contains ("->"))
                    {
                        String[] partes = line.split ("->");
                        String[] claves = partes[0].trim ().split (",");
                        tabla
                            .computeIfAbsent (claves[0].trim (),
                                              k -> new HashMap<> ())
                            .put (claves[1].trim (), partes[1].trim ());
                    }
            }
        reader.close ();
    }

    public String
    parse (String cadenaTokens)
    {
        tokens = new ArrayList<> (
            Arrays.asList (cadenaTokens.trim ().split ("\\s+")));
        tokens.add ("$");

        pila.clear ();
        pila.push ("$");
        pila.push (START_SYMBOL);

        output = " Analizando: " + cadenaTokens + " $\n\n";

        int i = 0;
        checkState = true;

        while (!pila.isEmpty () && i < tokens.size ())
            {
                top = pila.peek ();
                currentToken = tokens.get (i);

                if (top.equals (currentToken))
                    {
                        output += "✔️ Coincide terminal: \"" + top + "\"\n\n";
                        pila.pop ();
                        i++;
                        continue;
                    }
                if (tabla.containsKey (top))
                    {
                        regla = tabla.getOrDefault (top, new HashMap<> ())
                                    .get (currentToken);
                        if (regla == null)
                            {
                                regla = "ε";
                            }

                        pila.pop ();
                        if (!regla.equals ("ε"))
                            {
                                List<String> produccion
                                    = Arrays.asList (regla.split ("\\s+"));
                                Collections.reverse (produccion);
                                for (String simbolo : produccion)
                                    {
                                        pila.push (simbolo);
                                    }
                            }
                        output += " * " + top + " -> " + regla + "\n";
                        continue;
                    }
                output += "❌ Error: se esperaba: \"" + top
                          + "\" pero llegó \"" + currentToken + "\"\n\n";
                checkState = false;
                break;
            }
        return output;
    }

    public Boolean
    getCheckState ()
    {
        return checkState;
    }
}
