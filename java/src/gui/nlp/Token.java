package gui.nlp;

public class Token
{
    private String lexema, token, pos;

    public Token ()
    {
        lexema = null;
        token = null;
        pos = null;
    }

    public void
    setLexema (String lexema)
    {
        this.lexema = lexema;
    }

    public String
    getLexema ()
    {
        return lexema;
    }

    public void
    setToken (String token)
    {
        this.token = token;
    }

    public String
    getToken ()
    {
        return token;
    }

    public void
    setPos (String pos)
    {
        this.pos = pos;
    }

    public String
    getPos ()
    {
        return pos;
    }
}
