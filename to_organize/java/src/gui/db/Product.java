package gui.db;

public class Product
{
    private String ID, name, amount;

    public String
    getID ()
    {
        return ID;
    }

    public void
    setID (String iD)
    {
        ID = iD;
    }

    public String
    getName ()
    {
        return name;
    }

    public void
    setName (String name)
    {
        this.name = name;
    }

    public String
    getAmount ()
    {
        return amount;
    }

    public void
    setAmount (String amount)
    {
        this.amount = amount;
    }
}
