package gui.db;

import gui.db.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controller implements ActionListener
{
    private InventoryFrame inventoryFrame;
    private LoginFrame loginFrame;
    private RegisterFrame registerFrame;
    private RecoverFrame recoverFrame;
    private static Model model;

    private String text, intText;

    public Controller (InventoryFrame inventoryFrame)
    {
        this.inventoryFrame = inventoryFrame;
        startUp ();
    }

    public Controller (LoginFrame loginFrame)
    {
        this.loginFrame = loginFrame;
        startUp ();
    }

    public Controller (RegisterFrame registerFrame)
    {
        this.registerFrame = registerFrame;
        startUp ();
    }

    public Controller (RecoverFrame recoverFrame)
    {
        this.recoverFrame = recoverFrame;
        startUp ();
    }

    private void
    startUp ()
    {
        model = new Model ();
        text = "";
        intText = "";
    }

    public void
    actionPerformed (ActionEvent event)
    {
        switch (event.getActionCommand ())
            {
            case "OK":
                text = loginFrame.getTextFieldUser ();
                intText = loginFrame.getPasswordField ();
                if (!model.authentication (text, intText))
                    {
                        JOptionPane.showMessageDialog (
                            null, "AUTENTICACIÓN FALLIDA");
                        return;
                    }
                inventoryFrame = new InventoryFrame ();
                inventoryFrame.setVisible (true);
                inventoryFrame.fillTable (model.retrieveProducts ());
                loginFrame.setVisible (false);
                break;

            case "Recuperar contraseña":
                recoverFrame = new RecoverFrame ();
                recoverFrame.setVisible (true);
                loginFrame.setVisible (false);
                break;

            case "HEY_WHAT?":
                registerFrame = new RegisterFrame ();
                registerFrame.setVisible (true);
                loginFrame.setVisible (false);
                break;

            case "CROISSANT_EMOJI":
                text = registerFrame.getTextFieldUser ();
                intText = registerFrame.getPasswordField ();
                if (text.equals ("") || intText.equals (""))
                    {
                        JOptionPane.showMessageDialog (
                            null, "Por favor, rellene todos los campos");
                        return;
                    }
                model.insertUser (text, intText);
                JOptionPane.showMessageDialog (null, "Usuario recuperado");
                returnLogin (registerFrame);
                break;

            case "FUCK_U":

                returnLogin (registerFrame);
                break;

            case "Eliminar":
                text = inventoryFrame.getTextFieldIDProduct ();
                intText = inventoryFrame.getTextFieldName ();
                if (text.equals ("") || intText.equals (""))
                    {
                        JOptionPane.showMessageDialog (
                            null, "Por favor, rellene todos los campos");
                        return;
                    }
                model.deleteFromUser (text, intText);
                inventoryFrame.setTableModel ();
                inventoryFrame.fillTable (model.retrieveProducts ());
                break;

            case "Insertar":
                text = inventoryFrame.getTextFieldName ();
                intText = inventoryFrame.getTextFieldAmount ();
                if (text.equals ("") || intText.equals (""))
                    {
                        JOptionPane.showMessageDialog (
                            null, "Por favor, rellene todos los campos");
                        return;
                    }
                model.insertFromUser (text, intText);
                inventoryFrame.setTableModel ();
                inventoryFrame.fillTable (model.retrieveProducts ());
                break;

            case "Cerrar sesión":

                returnLogin (inventoryFrame);
                break;

            case "ANXIETY":
                text = recoverFrame.getTextFieldUser ();
                intText = recoverFrame.getPasswordField ();
                if (text.equals ("") || intText.equals (""))
                    {
                        JOptionPane.showMessageDialog (
                            null, "Por favor, rellene todos los campos");
                        return;
                    }
                model.updateUser (text, intText);
                JOptionPane.showMessageDialog (null, "Usuario registrado");
                returnLogin (recoverFrame);
                break;

            case "MUTAFUKAZ":
                returnLogin (recoverFrame);
                break;
            }
    }

    private void
    returnLogin (JFrame thing)
    {
        thing.dispose ();
        if (loginFrame == null)
            loginFrame = new LoginFrame ();
        loginFrame.setVisible (true);
    }
}
