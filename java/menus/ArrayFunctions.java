package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ArrayFunctions implements ActionListener {
  private ArrayList<Worker> listWorkers;
  private Worker node;
  private jFrameWorker jfw;

  private int id = 0, salary = 0;
  private static int num;
  private String s;
  private static String txt;

  public ArrayFunctions(jFrameWorker jfw) {
    listWorkers = new ArrayList<Worker>();
    this.jfw = jfw;
  }
  public void actionPerformed(ActionEvent actEv) {
    s = actEv.getActionCommand();
    verifyNumbers();
    switch (s) {
    case "Guardar":
      saveWorker();
      break;
    case "Limpiar":
      clearTextFields();
      break;

    case "Buscar":
      searchWorker();
      break;

    case "Borrar":
      for (Worker var : listWorkers) {
        if (var.getID() == id) {
          listWorkers.remove(var);
          clearTextFields();
          jfw.setLabel("Trabajador " + var.getName() + " eliminado");
          return;
        }
      }
      jfw.setLabel("Dato se encuentra el trabajador con documento: " + id);
      break;

    case "Cerrar":
      jfw.dispose();
      break;
    }
  }
  public void saveWorker() {
    if (id == 0 || salary == 0 || jfw.textFieldName.getText().equals("") ||
        jfw.textFieldAddress.getText().equals("") ||
        jfw.textFieldPhone.getText().equals("")) {
      jfw.setLabel(
          "Por favor, complete de forma adecuada los campos presentados");
      return;
    }
    node = new Worker(
        id, salary, jfw.textFieldName.getText(), jfw.textFieldAddress.getText(),
        jfw.textFieldPhone.getText(), (String)jfw.regions.getSelectedItem());
    listWorkers.add(node);
    jfw.setLabel("Ingeso del trabajdor exitoso");
  }
  public void searchWorker() {
    if (id == 0) {
      jfw.setLabel(
          "Complete el campo del documento u del salario correctamente");
      return;
    }
    for (Worker var : listWorkers) {
      if (var.getID() == id) {
        jfw.textFieldName.setText(var.getName());
        jfw.textFieldAddress.setText(var.getAddress());
        jfw.textFieldPhone.setText(var.getPhone());
        jfw.textFieldSalary.setText(String.valueOf(var.getSalary()));
        jfw.regions.setSelectedItem((Object)var.getRegion());
        jfw.setLabel("Trabajador encontrado");
        return;
      }
    }
    jfw.setLabel("Dato se encuentra el trabajador con documento: " + id);
  }
  public void clearTextFields() {
    jfw.textFieldID.setText("");
    jfw.textFieldName.setText("");
    jfw.textFieldAddress.setText("");
    jfw.textFieldPhone.setText("");
    jfw.textFieldSalary.setText("");
    jfw.regions.setSelectedIndex(0);
  }
  public void verifyNumbers() {
    if (isInteger(jfw.textFieldID))
      id = num;
    if (isInteger(jfw.textFieldSalary))
      salary = num;
  }
  public boolean isInteger(javax.swing.JTextField aux) {
    txt = aux.getText();
    try {
      num = Integer.parseInt(txt);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
