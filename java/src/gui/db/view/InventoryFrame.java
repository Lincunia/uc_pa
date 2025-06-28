package gui.db.view;

import gui.db.Controller;
import gui.db.Product;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class InventoryFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField textFieldIDProduct;
  private JTextField textFieldName;
  private JTextField textFieldAmount;
  private JTable productTable;
  private DefaultTableModel model;
  private static Controller controller;
  private Object row[];

  public InventoryFrame() {
    controller = new Controller(this);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 359);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);
    setResizable(false);

    JLabel titleInventory = new JLabel("GESTIÓN INVENTARIO");
    titleInventory.setBounds(135, 11, 190, 22);
    titleInventory.setFont(new Font("Monospaced", Font.BOLD, 16));
    contentPane.add(titleInventory);

    JLabel lblIdproducto = new JLabel("ID del producto:");
    lblIdproducto.setBounds(10, 45, 128, 20);
    lblIdproducto.setFont(new Font("Monospaced", Font.PLAIN, 14));
    contentPane.add(lblIdproducto);

    textFieldIDProduct = new JTextField();
    textFieldIDProduct.setBounds(145, 42, 279, 26);
    textFieldIDProduct.setFont(new Font("Monospaced", Font.PLAIN, 14));
    textFieldIDProduct.setColumns(10);
    contentPane.add(textFieldIDProduct);

    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setFont(new Font("Monospaced", Font.PLAIN, 14));
    lblNombre.setBounds(10, 76, 56, 20);
    contentPane.add(lblNombre);

    JLabel lblCantidad = new JLabel("Cantidad:");
    lblCantidad.setFont(new Font("Monospaced", Font.PLAIN, 14));
    lblCantidad.setBounds(10, 107, 72, 20);
    contentPane.add(lblCantidad);

    textFieldName = new JTextField();
    textFieldName.setFont(new Font("Monospaced", Font.PLAIN, 14));
    textFieldName.setColumns(10);
    textFieldName.setBounds(145, 77, 279, 26);
    contentPane.add(textFieldName);

    textFieldAmount = new JTextField();
    textFieldAmount.setFont(new Font("Monospaced", Font.PLAIN, 14));
    textFieldAmount.setColumns(10);
    textFieldAmount.setBounds(145, 108, 279, 26);
    contentPane.add(textFieldAmount);

    JButton btnDelete = new JButton("Eliminar");
    btnDelete.setBounds(335, 145, 89, 23);
    contentPane.add(btnDelete);
    btnDelete.addActionListener(controller);

    JButton btnInsertar = new JButton("Insertar");
    btnInsertar.setBounds(236, 145, 89, 23);
    contentPane.add(btnInsertar);
    btnInsertar.addActionListener(controller);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 179, 414, 130);
    contentPane.add(scrollPane);

    productTable = new JTable();
    setTableModel();

    scrollPane.setViewportView(productTable);

    JButton btnLogout = new JButton("Cerrar sesión");
    btnLogout.setBounds(110, 145, 114, 23);
    contentPane.add(btnLogout);
    btnLogout.addActionListener(controller);
  }

  public void fillTable(List<Product> retrivedInformation) {
    for (Product prod : retrivedInformation) {
      row = new Object[3];
      row[0] = prod.getID();
      row[1] = prod.getName();
      row[2] = prod.getAmount();
      model.addRow(row);
    }
  }

  public void setTableModel() {
    model = new DefaultTableModel();
    productTable.setModel(model);

    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Cantidad");
  }
  public String getTextFieldIDProduct() { return textFieldIDProduct.getText(); }

  public void setTextFieldIDProduct(String textFieldIDProduct) {
    this.textFieldIDProduct.setText(textFieldIDProduct);
  }

  public String getTextFieldName() { return textFieldName.getText(); }

  public void setTextFieldName(String textFieldName) {
    this.textFieldName.setText(textFieldName);
  }

  public String getTextFieldAmount() { return textFieldAmount.getText(); }

  public void setTextFieldAmount(String textFieldAmount) {
    this.textFieldAmount.setText(textFieldAmount);
  }
}
