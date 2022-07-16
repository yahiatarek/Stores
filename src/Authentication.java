import javax.swing.*;

public class Authentication {
  private static String adminUserName = "admin";
  private static int adminPassword = 123456;

  public static void setAdminPassword() {
    int oldPass = Integer.parseInt(
      GuiPanes.inputDialogBox("Please enter old Password")
    );
    if (oldPass == adminPassword) {
      adminPassword =
        Integer.parseInt(GuiPanes.inputDialogBox("Please enter new password"));
      GuiPanes.showMessage("your password is changed");
    }
  }

  public static String login() {
    return GuiPanes.createAuthPanel(adminPassword, adminUserName);
  }
}
