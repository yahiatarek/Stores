public class Authentication {
  private static String adminUserName = "admin";
  private static int adminPassword = 123456;
  static String salesManUser = "admin";
  private static int salesManPass = 123456;

  public static void login(String adminOrSalesMan) {
    if (adminOrSalesMan == "admin") {
      GuiPanes.createAuthPanel(salesManPass, salesManUser);
      adminTransactions();
    } else {
      GuiPanes.createAuthPanel(adminPassword, adminUserName);
      salesManTransactions();
    }
  }

  private static void adminTransactions() {
    GuiPanes.inputDialogBox(
      "please choose a transaction\n1-add a store\n2-add a product 3- add a supplier"
    );
  }

  private static void salesManTransactions() {
    GuiPanes.createProductPanel();
  }
}
