package gui.nlp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame
{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblTitulo;
    private JLabel lblPreguntas;
    private JLabel lblTokenizacin;
    private JLabel lblAlexico;
    private JLabel lblASintactico;
    private JLabel lblRespuesta;
    private JLabel lblNewLabel;

    private JTextField textFieldQuestion;
    private JTextField textFieldSyntactic;
    private JTextField textFieldResponse;
    private JTextPane textPaneAnalisisDetalle;

    private JButton btnLexicalAnalysis;
    private JButton btnSyntacticalAnalysis;
    private JButton btnResponse;

    private JScrollPane scrollPane;

    private Controller controller;
    private JTextField textFieldTokens1;
    private JTextField textFieldTokens2;
    private JLabel lblTokenizacin_1;
    private JTable symbolTableU;
    private DefaultTableModel userST;
    private DefaultTableModel programST;
    private JScrollPane scrollPane_2;
    private JTable symbolTableP;
    private JLabel lblTokenizacin_2;

    public View ()
    {
        generateControls ();
        addActionListeners ();
    }

    public void
    generateControls ()
    {
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setBounds (100, 100, 959, 509);
        setResizable (false);
        contentPane = new JPanel ();
        contentPane.setBackground (new Color (226, 252, 222));
        contentPane.setBorder (new EmptyBorder (5, 5, 5, 5));
        setContentPane (contentPane);
        contentPane.setLayout (null);

        lblTitulo = new JLabel ("Bienvenido a Pandaderia");
        lblTitulo.setFont (new Font ("Tahoma", Font.BOLD, 26));
        lblTitulo.setForeground (new Color (75, 0, 130));
        lblTitulo.setBounds (311, 11, 325, 30);
        contentPane.add (lblTitulo);

        lblPreguntas = new JLabel ("Escribe tu pregunta:");
        lblPreguntas.setFont (new Font ("Tahoma", Font.PLAIN, 15));
        lblPreguntas.setBounds (10, 60, 131, 25);
        contentPane.add (lblPreguntas);

        textFieldQuestion = new JTextField ();
        textFieldQuestion.setFont (new Font ("Monospaced", Font.PLAIN, 16));
        textFieldQuestion.setBounds (171, 59, 759, 25);
        contentPane.add (textFieldQuestion);
        textFieldQuestion.setColumns (10);

        btnLexicalAnalysis = new JButton ("Análisis Léxico");
        btnLexicalAnalysis.setFont (new Font ("Monospaced", Font.PLAIN, 15));
        btnLexicalAnalysis.setBackground (new Color (135, 206, 250));
        btnLexicalAnalysis.setBounds (10, 94, 209, 25);
        contentPane.add (btnLexicalAnalysis);

        lblAlexico = new JLabel ("Tokens Lematizados:");
        lblAlexico.setFont (new Font ("Tahoma", Font.PLAIN, 14));
        lblAlexico.setBounds (10, 130, 150, 20);
        contentPane.add (lblAlexico);

        lblTokenizacin = new JLabel ("Tokens Filtrados:");
        lblTokenizacin.setFont (new Font ("Tahoma", Font.PLAIN, 14));
        lblTokenizacin.setBounds (10, 197, 150, 20);
        contentPane.add (lblTokenizacin);

        btnSyntacticalAnalysis = new JButton ("Análisis Sintáctico");
        btnSyntacticalAnalysis.setFont (
            new Font ("Monospaced", Font.PLAIN, 15));
        btnSyntacticalAnalysis.setBackground (new Color (255, 182, 193));
        btnSyntacticalAnalysis.setBounds (320, 95, 209, 24);
        contentPane.add (btnSyntacticalAnalysis);

        lblASintactico = new JLabel ("Resultado Sintáctico:");
        lblASintactico.setFont (new Font ("Tahoma", Font.PLAIN, 14));
        lblASintactico.setBounds (320, 398, 180, 25);
        contentPane.add (lblASintactico);

        textFieldSyntactic = new JTextField ();
        textFieldSyntactic.setFont (new Font ("Monospaced", Font.PLAIN, 16));
        textFieldSyntactic.setBounds (320, 434, 300, 25);
        textFieldSyntactic.setColumns (10);
        textFieldSyntactic.setEditable (false);
        contentPane.add (textFieldSyntactic);

        lblRespuesta = new JLabel ("Respuesta Generada:");
        lblRespuesta.setFont (new Font ("Tahoma", Font.PLAIN, 14));
        lblRespuesta.setBounds (630, 128, 180, 25);
        contentPane.add (lblRespuesta);

        textFieldResponse = new JTextField ();
        textFieldResponse.setFont (new Font ("Monospaced", Font.PLAIN, 15));
        textFieldResponse.setBounds (630, 164, 300, 25);
        textFieldResponse.setColumns (10);
        textFieldResponse.setEditable (false);
        contentPane.add (textFieldResponse);

        btnResponse = new JButton ("Generar Respuesta");
        btnResponse.setFont (new Font ("Monospaced", Font.PLAIN, 15));
        btnResponse.setBackground (new Color (144, 238, 144));
        btnResponse.setBounds (630, 95, 209, 24);
        contentPane.add (btnResponse);

        lblNewLabel = new JLabel ("Detalles del Análisis:");
        lblNewLabel.setFont (new Font ("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds (320, 130, 180, 20);
        contentPane.add (lblNewLabel);

        textPaneAnalisisDetalle = new JTextPane ();
        textPaneAnalisisDetalle.setFont (
            new Font ("Monospaced", Font.PLAIN, 15));
        textPaneAnalisisDetalle.setEditable (false);
        scrollPane = new JScrollPane (textPaneAnalisisDetalle);
        scrollPane.setBounds (320, 161, 300, 226);
        scrollPane.setVerticalScrollBarPolicy (
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPane.add (scrollPane);

        textFieldTokens1 = new JTextField ();
        textFieldTokens1.setFont (new Font ("Monospaced", Font.PLAIN, 15));
        textFieldTokens1.setEditable (false);
        textFieldTokens1.setColumns (10);
        textFieldTokens1.setBounds (10, 161, 300, 25);
        contentPane.add (textFieldTokens1);

        textFieldTokens2 = new JTextField ();
        textFieldTokens2.setFont (new Font ("Monospaced", Font.PLAIN, 15));
        textFieldTokens2.setEditable (false);
        textFieldTokens2.setColumns (10);
        textFieldTokens2.setBounds (10, 228, 300, 25);
        contentPane.add (textFieldTokens2);

        lblTokenizacin_1 = new JLabel ("Tabla de símbolos:");
        lblTokenizacin_1.setFont (new Font ("Tahoma", Font.PLAIN, 14));
        lblTokenizacin_1.setBounds (10, 264, 150, 20);
        contentPane.add (lblTokenizacin_1);

        JScrollPane scrollPane_1 = new JScrollPane ((Component)null);
        scrollPane_1.setVerticalScrollBarPolicy (
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane_1.setBounds (10, 295, 300, 164);
        contentPane.add (scrollPane_1);

        userST = new DefaultTableModel ();
        userST.setColumnIdentifiers (
            new String[] { "Lexema", "Token", "POS" });
        symbolTableU = new JTable (userST);
        symbolTableU.setFont (new Font ("Monospaced", Font.PLAIN, 15));
        scrollPane_1.setViewportView (symbolTableU);

        scrollPane_2 = new JScrollPane ((Component)null);
        scrollPane_2.setVerticalScrollBarPolicy (
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane_2.setBounds (630, 232, 300, 164);
        contentPane.add (scrollPane_2);

        programST = new DefaultTableModel ();
        programST.setColumnIdentifiers (
            new String[] { "Lexema", "Token", "POS" });
        symbolTableP = new JTable (programST);
        scrollPane_2.setViewportView (symbolTableP);
        symbolTableP.setFont (new Font ("Monospaced", Font.PLAIN, 15));

        lblTokenizacin_2 = new JLabel ("Tabla de símbolos:");
        lblTokenizacin_2.setFont (new Font ("Tahoma", Font.PLAIN, 14));
        lblTokenizacin_2.setBounds (630, 197, 150, 20);
        contentPane.add (lblTokenizacin_2);

        setBtnSyntacticalAnalysis (false);
        setBtnResponse (false);
    }
    public void
    addActionListeners ()
    {
        controller = new Controller (this);
        btnLexicalAnalysis.addActionListener (controller);
        btnSyntacticalAnalysis.addActionListener (controller);
        btnResponse.addActionListener (controller);
    }

    public void
    setBtnSyntacticalAnalysis (Boolean state)
    {
        this.btnSyntacticalAnalysis.setEnabled (state);
    }

    public void
    setBtnResponse (Boolean state)
    {
        this.btnResponse.setEnabled (state);
    }

    public void
    setTextFieldQuestion (String textFieldQuestion)
    {
        this.textFieldQuestion.setText (textFieldQuestion);
    }

    public String
    getTextFieldQuestion ()
    {
        return textFieldQuestion.getText ();
    }

    public void
    setTextFieldSyntactic (String textFieldSyntactic)
    {
        this.textFieldSyntactic.setText (textFieldSyntactic);
    }

    public String
    getTextFieldSyntactic ()
    {
        return textFieldSyntactic.getText ();
    }

    public void
    setTextFieldResponse (String textFieldResponse)
    {
        this.textFieldResponse.setText (textFieldResponse);
    }

    public String
    getTextFieldResponse ()
    {
        return textFieldResponse.getText ();
    }

    public void
    setTextFieldTokens1 (String textFieldTokens1)
    {
        this.textFieldTokens1.setText (textFieldTokens1);
    }

    public String
    getTextFieldTokens1 ()
    {
        return textFieldTokens1.getText ();
    }

    public void
    setTextFieldTokens2 (String textFieldTokens2)
    {
        this.textFieldTokens2.setText (textFieldTokens2);
    }

    public String
    getTextFieldTokens2 ()
    {
        return textFieldTokens2.getText ();
    }

    public void
    setTextPaneAnalisisDetalle (String content)
    {
        textPaneAnalisisDetalle.setText (content);
    }

    public void
    addUserSymbolTable (String l, String t, String p)
    {
        userST.addRow (new Object[] { l, t, p });
    }

    public void
    addProgramSymbolTable (String l, String t, String p)
    {
        programST.addRow (new Object[] { l, t, p });
    }

    public void
    programSymbolTable (String l, String t, String p)
    {
        programST.addRow (new Object[] { l, t, p });
    }

    public void
    clearUserSymbolTable ()
    {
        userST.setRowCount (0);
    }

    public void
    clearProgramSymbolTable ()
    {
        programST.setRowCount (0);
    }
}
