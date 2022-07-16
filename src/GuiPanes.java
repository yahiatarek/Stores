import java.awt.GridLayout;
import javax.swing.*;

public class GuiPanes {

  public static void showMessage(String message) {
    JOptionPane.showMessageDialog(null, message);
  }

  public static String inputDialogBox(String message) {
    return JOptionPane.showInputDialog(null, message);
  }

  public static String createAuthPanel(
    int currentAdminPassword,
    String currentAdminUserName
  ) {
    JPanel loginPanel = new JPanel(new GridLayout(0, 1));
    JTextField userNameField = new JTextField();
    loginPanel.add(new JLabel("User name:"));
    loginPanel.add(userNameField);
    JTextField passwordField = new JTextField();
    loginPanel.add(new JLabel("password:"));
    loginPanel.add(passwordField);

    final int result = JOptionPane.showConfirmDialog(
      null,
      loginPanel,
      "Login",
      JOptionPane.OK_CANCEL_OPTION,
      JOptionPane.PLAIN_MESSAGE
    );

    if (
      (result == JOptionPane.OK_OPTION) &&
      (currentAdminUserName == userNameField.getText()) &&
      (currentAdminPassword == Integer.parseInt(passwordField.getText()))
    ) {
      return "successfully";
    } else {
      return "Cancelled";
    }
  }
}
