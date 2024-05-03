package menus;

import java.awt.*;
import javax.swing.*;
public class jFrameWorker extends JFrame {
  // private static final long serialVersionUID = 1;
  private ArrayFunctions controller;
  private JPanel background, buttons, inputPanel, labels;
  private JLabel title, labelID, labelName, labelAddress, labelPhone,
      labelSalary, labelRegion, labelInfo;
  private JButton buttonSave, buttonClear, buttonClose, buttonSearch,
      buttonDelete;
  private String regionsArray[] = {"Región Andina", "Región Amazona",
                                   "Región Atlantica", "Región Pacífica",
                                   "Región Orinoquía"};

  JTextField textFieldID, textFieldName, textFieldAddress, textFieldPhone,
      textFieldSalary;
  JComboBox<String> regions;

  public jFrameWorker(int width, int height) {
    this.setTitle("Trabajadores");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100, 100, width, height);
    setResizable(false);
    initComponents();
    addToTheFrame();
    setVisible(true);
    initListeners();
  }
  public void setPanelsLayouts() {
    background = new JPanel();
    background.setBackground(Color.WHITE);
    background.setLayout(null);
    setContentPane(background);
    labels = new JPanel();
    labels.setBounds(5, 40, 100, 150);
    inputPanel = new JPanel();
    inputPanel.setBounds(110, 40, 160, 150);
    buttons = new JPanel();
    buttons.setBounds(280, 40, 100, 150);
  }
  public void initComponents() {
    setPanelsLayouts();
    title = new JLabel("Insertar trabajadores");
    title.setFont(new Font("Roboto", Font.PLAIN, 30));
    title.setSize(300, 30);
    title.setLocation(25, 5);

    labelInfo = new JLabel();
    labelInfo.setBounds(5, 200, 400, 15);

    labelID = new JLabel("Documento: ");
    labelID.setFont(new Font("Roboto", Font.PLAIN, 16));
    textFieldID = new JTextField(10);

    labelName = new JLabel("Nombre: ");
    labelName.setFont(new Font("Roboto", Font.PLAIN, 16));
    textFieldName = new JTextField(10);

    labelAddress = new JLabel("Dirección: ");
    labelAddress.setFont(new Font("Roboto", Font.PLAIN, 16));
    textFieldAddress = new JTextField(10);

    labelPhone = new JLabel("Teléfono: ");
    labelPhone.setFont(new Font("Roboto", Font.PLAIN, 16));
    textFieldPhone = new JTextField(10);

    labelSalary = new JLabel("Sueldo: ");
    labelSalary.setFont(new Font("Roboto", Font.PLAIN, 16));
    textFieldSalary = new JTextField(10);

    labelRegion = new JLabel("Región: ");
    labelRegion.setFont(new Font("Roboto", Font.PLAIN, 16));
    regions = new JComboBox<String>(regionsArray);

    buttonSave = new JButton("Guardar");
    buttonClear = new JButton("Limpiar");
    buttonClose = new JButton("Cerrar");
    buttonSearch = new JButton("Buscar");
    buttonDelete = new JButton("Borrar");

    controller = new ArrayFunctions(this);
  }
  public void addToTheFrame() {
    this.add(title);
    labels.add(labelID);
    labels.add(labelName);
    labels.add(labelAddress);
    labels.add(labelPhone);
    labels.add(labelSalary);
    labels.add(labelRegion);

    inputPanel.add(textFieldID);
    inputPanel.add(textFieldName);
    inputPanel.add(textFieldAddress);
    inputPanel.add(textFieldPhone);
    inputPanel.add(textFieldSalary);
    inputPanel.add(regions);

    buttons.add(buttonSave);
    buttons.add(buttonClear);
    buttons.add(buttonClose);
    buttons.add(buttonSearch);
    buttons.add(buttonDelete);

    this.add(labelInfo);
    this.add(labels);
    this.add(inputPanel);
    this.add(buttons);
  }
  public void initListeners() {
    buttonSave.addActionListener(controller);
    buttonClear.addActionListener(controller);
    buttonClose.addActionListener(controller);
    buttonSearch.addActionListener(controller);
    buttonDelete.addActionListener(controller);
  }
  public void setLabel(String txt) { labelInfo.setText(txt); }
}
