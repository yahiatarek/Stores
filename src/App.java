import database.SelectFromSQLServer;

public class App {

  public static void main(String[] args) throws Exception {
    SelectFromSQLServer.runSqlServerConnection();
    GuiPanes.showMessage("Welcome to Stores.");
    int userChoice = Integer.parseInt(
      GuiPanes.inputDialogBox(
        "Please choose from the following:\n1- Selling Transaction\n2-Login as Admin"
      )
    );
    if (userChoice == 2) {
      Authentication.login();
    }
  }
}
