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

public class RegisterFrame extends JFrame
{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldUser;
    private JPasswordField passwordField;
    private static Controller controller;

    public RegisterFrame ()
    {
        controller = new Controller (this);

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setBounds (100, 100, 388, 192);
        contentPane = new JPanel ();
        contentPane.setBorder (new EmptyBorder (5, 5, 5, 5));

        setContentPane (contentPane);
        contentPane.setLayout (null);
        setResizable (false);

        JLabel titleRegister = new JLabel ("REGISTRO DE USUARIO");
        titleRegister.setBounds (75, 11, 190, 22);
        titleRegister.setFont (new Font ("Monospaced", Font.BOLD, 16));
        contentPane.add (titleRegister);

        JLabel lblUser = new JLabel ("Nombre de usuario:");
        lblUser.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        lblUser.setBounds (10, 45, 144, 22);
        contentPane.add (lblUser);

        textFieldUser = new JTextField ();
        textFieldUser.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        textFieldUser.setBounds (164, 46, 192, 20);
        contentPane.add (textFieldUser);
        textFieldUser.setColumns (10);

        JLabel lblPassword = new JLabel ("Contraseña:");
        lblPassword.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        lblPassword.setBounds (10, 77, 144, 22);
        contentPane.add (lblPassword);

        passwordField = new JPasswordField ();
        passwordField.setBounds (164, 77, 192, 20);
        contentPane.add (passwordField);

        JButton btnRegister = new JButton ("Registrarse");
        btnRegister.setBounds (10, 110, 160, 23);
        contentPane.add (btnRegister);
        btnRegister.addActionListener (controller);
        btnRegister.setActionCommand ("CROISSANT_EMOJI");

        JButton btnLogin = new JButton ("Iniciar sesión");
        btnLogin.setBounds (196, 110, 160, 23);
        contentPane.add (btnLogin);
        btnLogin.addActionListener (controller);
        btnLogin.setActionCommand ("FUCK_U");
        /*
    ♪ Mixed messages ♪
    ♪ Mixed messages ♪
    ♪ One second, I say you're very pretty (very pretty) ♪
    ♪ And then I show up at your house and I kick your dog, yeah ♪
         */
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
