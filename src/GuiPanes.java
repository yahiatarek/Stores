import Product.Product;
import database.shopService;
import java.awt.GridLayout;
import javax.swing.*;

public class GuiPanes {

  public static void showMessage(String message) {
    JOptionPane.showMessageDialog(null, message);
  }

  public static String inputDialogBox(String message) {
    return JOptionPane.showInputDialog(null, message);
  }

  public static void createAuthPanel(
    int currentPassword,
    String currentUserName
  ) {
    JPanel loginPanel = new JPanel(new GridLayout(0, 1));
    JTextField userNameField = createField(loginPanel, "User name:");
    JTextField passwordField = createField(loginPanel, "password:");
    int result = 0;
    do {
      result =
        JOptionPane.showConfirmDialog(
          null,
          loginPanel,
          "Login",
          JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.PLAIN_MESSAGE
        );
      if (
        currentUserName != userNameField.getText() &&
        currentPassword != Integer.parseInt(passwordField.getText())
      ) {
        showMessage("pls enter the correct name or password");
      }
    } while (
      currentUserName != userNameField.getText() &&
      currentPassword != Integer.parseInt(passwordField.getText()) &&
      (result == JOptionPane.OK_OPTION)
    );
  }

  public static void createProductPanel() {
    JPanel productPanel = new JPanel(new GridLayout(0, 1));
    JTextField productID = createField(productPanel, "productID");
    JTextField productCost = createField(productPanel, "productCost");
    JTextField productPrice = createField(productPanel, "productPrice");
    JTextField productQuantity = createField(productPanel, "productQuantity");
    JTextField productName = createField(productPanel, "productName");
    JTextField storeId = createField(productPanel, "storeId");

    int result = JOptionPane.showConfirmDialog(
      null,
      productPanel,
      "Add Product",
      JOptionPane.OK_CANCEL_OPTION,
      JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
      Product newProduct = new Product(
        Integer.parseInt(productID.getText()),
        Double.parseDouble(productCost.getText()),
        Double.parseDouble(productPrice.getText()),
        productQuantity.getText(),
        productName.getText(),
        Integer.parseInt(storeId.getText())
      );
      shopService.insertProductIntoDatabase(newProduct);
    }
  }

  private static JTextField createField(JPanel panel, String label) {
    JTextField field = new JTextField();
    panel.add(new JLabel(label));
    panel.add(field);
    return field;
  }
}
