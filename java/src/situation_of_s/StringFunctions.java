package situation_of_s;

public class StringFunctions
{
    void
    repetition (String str, char chr)
    {
        int repetitions = 0, i;
        for (i = 0; i < str.length (); i++)
            {
                if (str.charAt (i) == chr)
                    repetitions++;
            }
        System.out.println ("Repetitions of " + chr + ": " + repetitions);
    }

    void
    vocalAndNumericAmount (String str)
    {
        int vocalAmount = 0, numberAmount = 0;
        for (char car : str.toCharArray ())
            {
                switch (car)
                    {
                    case 'a', 'e', 'i', 'o', 'u' -> vocalAmount++;
                    }
                if (Character.isDigit (car))
                    numberAmount++;
            }
        System.out.println ("Vocals amount in a string: " + vocalAmount);
        System.out.println ("Numbers amount in a string: " + numberAmount);
    }

    void
    invert (String cadena)
    {
        String invertedStr = "";
        for (int i = cadena.length () - 1; i >= 0; i--)
            {
                invertedStr += cadena.charAt (i);
            }
        System.out.println ("Reversed string: " + invertedStr);
    }
}
