package gui.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Model
{
    private Connection connection;
    private final String connectionPath;
    private String sqlQuery;
    private Statement st;
    private ResultSet resultSet;
    private static Integer IDSesion;
    private Product refProd;

    public Model ()
    {
        connection = null;
        connectionPath = "jdbc:sqlite:inventario.db";
        try
            {
                Class.forName ("org.sqlite.JDBC");
                connection = DriverManager.getConnection (connectionPath);
            }
        catch (Exception e)
            {
                JOptionPane.showMessageDialog (null, e);
            }
    }

    public Boolean
    authentication (String user, String password)
    {
        String realUser = "", realPassword = "";
        resultSet = null;
        sqlQuery = "SELECT * FROM users WHERE username='" + user
                   + "' AND password='" + password + "';";
        try
            {
                st = connection.createStatement ();
                resultSet = st.executeQuery (sqlQuery);
                while (resultSet.next ())
                    {
                        realUser = resultSet.getString ("username");
                        realPassword = resultSet.getString ("password");
                        IDSesion
                            = Integer.valueOf (resultSet.getString ("id"));
                    }
            }
        catch (SQLException e)
            {
                JOptionPane.showMessageDialog (null, e);
            }
        if (realUser.equals (user) && realPassword.equals (password))
            {
                return true;
            }
        return false;
    }

    public void
    insertUser (String user, String password)
    {
        resultSet = null;
        sqlQuery = "INSERT INTO users (username, password) VALUES ('" + user
                   + "', '" + password + "');";
        try
            {
                st = connection.createStatement ();
                st.execute (sqlQuery);
            }
        catch (SQLException e)
            {
                JOptionPane.showMessageDialog (null, e);
            }
    }

    public List<Product>
    retrieveProducts ()
    {
        resultSet = null;
        List<Product> informationRetrieved = new LinkedList<> ();
        sqlQuery = "SELECT * FROM products WHERE id_user = " + IDSesion + ";";
        try
            {
                st = connection.createStatement ();
                resultSet = st.executeQuery (sqlQuery);
                while (resultSet.next ())
                    {
                        refProd = new Product ();
                        refProd.setID (resultSet.getString ("id"));
                        refProd.setName (resultSet.getString ("name"));
                        refProd.setAmount (resultSet.getString ("cantidad"));
                        informationRetrieved.add (refProd);
                    }
            }
        catch (SQLException e)
            {
                JOptionPane.showMessageDialog (null, e);
            }
        return informationRetrieved;
    }

    public void
    insertFromUser (String name, String amount)
    {
        resultSet = null;
        sqlQuery = "INSERT INTO products (name, cantidad, id_user) VALUES ('"
                   + name + "', " + amount + ", " + IDSesion + ");";
        try
            {
                st = connection.createStatement ();
                st.execute (sqlQuery);
            }
        catch (SQLException e)
            {
                JOptionPane.showMessageDialog (null, e);
            }
    }

    public void
    deleteFromUser (String id, String name)
    {
        sqlQuery = "DELETE FROM products WHERE name = '" + name
                   + "' AND id = " + id + ";";
        try
            {
                st = connection.createStatement ();
                st.execute (sqlQuery);
            }
        catch (SQLException e)
            {
                JOptionPane.showMessageDialog (null, e);
            }
    }

    public void
    updateUser (String user, String password)
    {
        sqlQuery = "UPDATE users SET password = '" + password
                   + "' WHERE username = '" + user + "';";
        try
            {
                st = connection.createStatement ();
                st.execute (sqlQuery);
            }
        catch (SQLException e)
            {
                JOptionPane.showMessageDialog (null, e);
            }
    }
}
