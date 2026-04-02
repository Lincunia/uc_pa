package gui.db.view;

import gui.db.Controller;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame
{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldUser;
    private JPasswordField passwordField;
    private static Controller controller;

    public LoginFrame ()
    {
        controller = new Controller (this);

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setBounds (100, 100, 422, 180);
        contentPane = new JPanel ();
        contentPane.setBorder (new EmptyBorder (5, 5, 5, 5));

        setContentPane (contentPane);
        contentPane.setLayout (null);
        setResizable (false);

        JLabel titleLogin = new JLabel ("INICIAR SESIÓN");
        titleLogin.setBounds (138, 11, 144, 22);
        titleLogin.setFont (new Font ("Monospaced", Font.BOLD, 16));
        contentPane.add (titleLogin);

        JLabel lblUser = new JLabel ("Nombre de usuario:");
        lblUser.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        lblUser.setBounds (10, 45, 144, 22);
        contentPane.add (lblUser);

        textFieldUser = new JTextField ();
        textFieldUser.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        textFieldUser.setBounds (164, 46, 232, 20);
        contentPane.add (textFieldUser);
        textFieldUser.setColumns (10);

        JLabel lblPassword = new JLabel ("Contraseña:");
        lblPassword.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        lblPassword.setBounds (10, 77, 144, 22);
        contentPane.add (lblPassword);

        passwordField = new JPasswordField ();
        passwordField.setBounds (164, 77, 232, 20);
        passwordField.setActionCommand ("OK");
        contentPane.add (passwordField);

        JButton btnLogin = new JButton ("Iniciar sesión");
        btnLogin.setBounds (10, 108, 110, 23);
        contentPane.add (btnLogin);
        btnLogin.addActionListener (controller);
        btnLogin.setActionCommand ("OK");

        JButton btnForgot = new JButton ("Recuperar contraseña");
        btnForgot.setBounds (229, 108, 167, 23);
        contentPane.add (btnForgot);
        btnForgot.addActionListener (controller);

        JButton btnRegister = new JButton ("Registrarse");
        btnRegister.setBounds (124, 108, 101, 23);
        contentPane.add (btnRegister);
        btnRegister.addActionListener (controller);
        btnRegister.setActionCommand ("HEY_WHAT?");
    }

    public String
    getTextFieldUser ()
    {
        return textFieldUser.getText ();
    }

    public void
    setTextFieldUser (String textFieldUser)
    {
        this.textFieldUser.setText (textFieldUser);
        ;
    }

    public String
    getPasswordField ()
    {
        String passwordString = "";
        for (char c : passwordField.getPassword ())
            {
                passwordString += c;
            }
        return passwordString;
    }

    public void
    setPasswordField (String passwordField)
    {
        this.passwordField.setText (passwordField);
    }
}
