package gui.nlp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tokenizer
{
    private Map<String, Token> dictionary;
    private Token token;
    private Set<String> stopwords;
    private BufferedReader reader;
    private String line;

    public Tokenizer ()
    {
        dictionary = new HashMap<> ();
        stopwords = new HashSet<> ();
    }

    public void
    loadTokens (String path) throws Exception
    {
        reader = new BufferedReader (new FileReader (path));
        String word;
        while ((line = reader.readLine ()) != null)
            {
                String[] partes = line.split (";");
                if (partes.length != 3)
                    {
                        continue;
                    }
                word = normalizeWord (partes[0]);
                token = new Token ();
                token.setLexema (partes[0]);
                token.setToken (partes[1]);
                token.setPos (partes[2]);
                dictionary.put (word, token);
            }
        reader.close ();
    }

    public List<Token>
    tokenizeString (List<String> words)
    {
        List<Token> tokens = new LinkedList<> ();
        int i = 0;
        String currentWord;
        String mixedWord;

        while (i < words.size ())
            {
                currentWord = normalizeWord (words.get (i));
                mixedWord = ((i + 1) < words.size ())
                                ? currentWord + " "
                                      + normalizeWord (words.get (i + 1))
                                : currentWord;
                if (dictionary.containsKey (mixedWord))
                    {
                        tokens.add (dictionary.get (mixedWord));
                        i += 2;
                        continue;
                    }
                if (dictionary.containsKey (currentWord))
                    {
                        tokens.add (dictionary.get (currentWord));
                        i++;
                        continue;
                    }
                token = new Token ();
                if (currentWord.matches ("\\d*"))
                    {
                        token.setLexema (words.get (i));
                        token.setToken ("int");
                        token.setPos ("numero");
                    }
                else
                    {
                        token.setLexema (words.get (i));
                        token.setToken ("ERROR");
                        token.setPos ("No reconocido");
                    }
                tokens.add (token);
                i++;
            }
        return tokens;
    }

    public void
    loadStopWords (String path) throws Exception
    {
        reader = new BufferedReader (new FileReader (path));
        while ((line = reader.readLine ()) != null)
            {
                stopwords.add (normalizeWord (line.trim ()));
            }
        reader.close ();
    }

    public List<String>
    filterStopWords (List<String> words)
    {
        List<String> result = new LinkedList<> ();
        for (String word : words)
            {
                if (!stopwords.contains (normalizeWord (word)))
                    {
                        result.add (word);
                    }
            }
        return result;
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
