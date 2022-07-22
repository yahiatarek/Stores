public class Authentication {
  private static String adminUserName = "admin";
  private static int adminPassword = 123456;
  static String salesManUser = "admin";
  private static int salesManPass = 123456;

  public static void login(String adminOrSalesMan) {
    if (adminOrSalesMan == "admin") {
      // GuiPanes.createAuthPanel(adminPassword, adminUserName);
      adminTransactions();
    } else {
      // GuiPanes.createAuthPanel(salesManPass, salesManUser);
      salesManTransactions();
    }
  }

  private static void adminTransactions() {
    int userChoice = 0;
    while (userChoice != 1 && userChoice != 2 && userChoice != 3) {
      userChoice =
        Integer.parseInt(
          GuiPanes.inputDialogBox(
            "please choose a transaction\n1-add a store\n2-add a product 3- add a supplier\n"
          )
        );
      if (userChoice == 1) {
        GuiPanes.createStorePanel();
      } else if (userChoice == 2) {
        GuiPanes.createProductPanel();
      } else if (userChoice == 3) {
        GuiPanes.createSupplierPanel();
      } else {
        GuiPanes.showMessage("please choose from the available options");
      }
    }
  }

  private static void salesManTransactions() {}
}
