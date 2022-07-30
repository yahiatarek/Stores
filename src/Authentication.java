import gui.GuiPanes;
import javax.swing.JOptionPane;

public class Authentication {
  private static String adminUserName = "admin";
  private static int adminPassword = 123456;
  private static String salesManUser = "admin";
  private static int salesManPass = 123456;

  public static void login(String adminOrSalesMan) {
    if (adminOrSalesMan == "admin") {
      GuiPanes.createAuthPanel(adminPassword, adminUserName);
      adminTransactions();
    } else {
      GuiPanes.createAuthPanel(salesManPass, salesManUser);
      salesManTransactions();
    }
  }

  private static void adminTransactions() {
    int userChoice = 0;
    while (userChoice != 1 && userChoice != 2 && userChoice != 3) {
      userChoice =
        Integer.parseInt(
          GuiPanes.inputDialogBox(
            "please choose a transaction\n1-add a store\n2-add a product\n3-add a special product\n4- add a supplier\n"
          )
        );
      if (userChoice == 1) {
        GuiPanes.createStorePanel();
      } else if (userChoice == 2) {
        GuiPanes.createProductPanel();
      } else if (userChoice == 3) {
        int result = 0;
        while (result != JOptionPane.CANCEL_OPTION) {
          GuiPanes.createProductPanel(true);
          result =
            JOptionPane.showConfirmDialog(
              null,
              "add another prodcut ?",
              "Add Product",
              JOptionPane.OK_CANCEL_OPTION,
              JOptionPane.PLAIN_MESSAGE
            );
        }
      } else if (userChoice == 4) {
        GuiPanes.createSupplierPanel();
      } else {
        GuiPanes.showMessage("please choose from the available options");
      }
    }
  }

  private static void salesManTransactions() {
    GuiPanes.showMessage("please insert selling transaction details");
    GuiPanes.createSellingPanel();
  }
}
