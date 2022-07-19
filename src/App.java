public class App {

  public static void main(String[] args) throws Exception {
    GuiPanes.showMessage("Welcome to Stores.");
    int userChoice = 0;
    while (userChoice != 1 && userChoice != 2) {
      userChoice =
        Integer.parseInt(
          GuiPanes.inputDialogBox(
            "Please choose from the following:\n1- Login as Sales man\n2-Login as Admin"
          )
        );
      if (userChoice == 2) {
        Authentication.login("admin");
      } else if (userChoice == 1) {
        Authentication.login("salesMan");
      } else {
        GuiPanes.showMessage("please choose from the available options");
      }
    }
  }
}
