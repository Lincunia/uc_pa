package gui.nlp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Controller implements ActionListener
{
    private View currentView;
    private Model model;
    private List<String> tokensInString, filteredWords;
    private List<Token> analyzedTokens;
    private String POScontent;

    public Controller (View view)
    {
        currentView = view;
        model = new Model (this);
        tokensInString = new ArrayList<> ();
        filteredWords = new LinkedList<> ();
    }

    public void
    actionPerformed (ActionEvent actEv)
    {
        if (currentView.getTextFieldQuestion ().equals (""))
            {
                displayMessage ("Por favor, inserte una pregunta");
                return;
            }
        switch (actEv.getActionCommand ())
            {
            case "Análisis Léxico":
                POScontent = "";
                currentView.clearUserSymbolTable ();

                tokensInString
                    = model.tokenization (currentView.getTextFieldQuestion ());
                currentView.setTextFieldTokens1 (
                    String.join (" ", tokensInString));

                filteredWords = model.filterStopWords (tokensInString);
                currentView.setTextFieldTokens2 (
                    String.join (" ", filteredWords));
                analyzedTokens = model.lexicalAnalyzer (filteredWords);
                for (Token token : analyzedTokens)
                    {
                        POScontent += (token.getPos () + " ");
                        currentView.addUserSymbolTable (token.getLexema (),
                                                        token.getToken (),
                                                        token.getPos ());
                    }

                currentView.setBtnSyntacticalAnalysis (true);
                break;

            case "Análisis Sintáctico":
                currentView.setTextPaneAnalisisDetalle (
                    model.analyzeSyntactically (POScontent));
                currentView.setTextFieldSyntactic (model.getParsingOutput ());
                currentView.setBtnResponse (true);
                break;

            case "Generar Respuesta":
                POScontent = "";
                currentView.clearProgramSymbolTable ();
                currentView.setTextFieldResponse (
                    model.generateResponse (analyzedTokens));
                tokensInString
                    = model.tokenization (currentView.getTextFieldResponse ());
                filteredWords = model.filterStopWords (tokensInString);
                analyzedTokens = model.lexicalAnalyzer (filteredWords);
                for (Token token : analyzedTokens)
                    {
                        POScontent += (token.getPos () + " ");
                        currentView.addProgramSymbolTable (token.getLexema (),
                                                           token.getToken (),
                                                           token.getPos ());
                    }
                break;
            }
    }

    public void
    displayMessage (String msg)
    {
        JOptionPane.showMessageDialog (null, msg);
    }
}
