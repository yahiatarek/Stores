package gui;

import Product.Product;
import Product.SpecialProduct;
import Sale_transactions.Client;
import Sale_transactions.Sale;
import Sale_transactions.Supplier;
import Store.Store;
import database.*;
import database.SaleTransactionsService;
import database.ShopService;
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
        Double.parseDouble(productCost.getText()),
        Double.parseDouble(productPrice.getText()),
        Double.parseDouble(productQuantity.getText()),
        productName.getText(),
        Integer.parseInt(storeId.getText())
      );
      ShopService.insertProductIntoDatabase(newProduct);
    }
  }

  public static void createProductPanel(Boolean isProductSpecial) {
    JPanel productPanel = new JPanel(new GridLayout(0, 1));
    JTextField productCost = createField(productPanel, "productCost");
    JTextField productPrice = createField(productPanel, "productPrice");
    JTextField productQuantity = createField(productPanel, "productQuantity");
    JTextField productName = createField(productPanel, "productName");
    JTextField productType = createField(productPanel, "productType");
    JTextField productColor = createField(productPanel, "productColor");
    JTextField storeId = createField(productPanel, "storeId");

    int result = JOptionPane.showConfirmDialog(
      null,
      productPanel,
      "Add Product",
      JOptionPane.OK_CANCEL_OPTION,
      JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
      SpecialProduct newProduct = new SpecialProduct(
        Double.parseDouble(productCost.getText()),
        Double.parseDouble(productPrice.getText()),
        Double.parseDouble(productQuantity.getText()),
        productName.getText(),
        Integer.parseInt(storeId.getText()),
        productType.getText(),
        productColor.getText()
      );
      SpecialProductDb.addToSpecialProducts(newProduct);
      SpecialProductDb.getSpecialProducts();
    }
  }

  public static void createStorePanel() {
    JPanel storePanel = new JPanel(new GridLayout(0, 1));
    JTextField storePhoneNo = createField(storePanel, "storePhoneNo");
    JTextField storeAddress = createField(storePanel, "storeAddress");
    JTextField storeName = createField(storePanel, "storeName");

    int result = JOptionPane.showConfirmDialog(
      null,
      storePanel,
      "Add Store",
      JOptionPane.OK_CANCEL_OPTION,
      JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
      Store newStore = new Store(
        Integer.parseInt(storePhoneNo.getText()),
        storeAddress.getText(),
        storeName.getText()
      );
      ShopService.insertStoreIntoDatabase(newStore);
    }
  }

  public static void createSupplierPanel() {
    JPanel supplierPanel = new JPanel(new GridLayout(0, 1));
    JTextField supplierPhoneNo = createField(supplierPanel, "supplierPhoneNo");
    JTextField supplierAddress = createField(supplierPanel, "supplierAddress");
    JTextField supplierName = createField(supplierPanel, "supplierName");

    int result = JOptionPane.showConfirmDialog(
      null,
      supplierPanel,
      "Add Supplier",
      JOptionPane.OK_CANCEL_OPTION,
      JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
      Supplier newSupplier = new Supplier(
        Integer.parseInt(supplierPhoneNo.getText()),
        supplierAddress.getText(),
        supplierName.getText()
      );
      ShopService.insertSupplierIntoDatabase(newSupplier);
    }
  }

  private static JTextField createField(JPanel panel, String label) {
    JTextField field = new JTextField();
    panel.add(new JLabel(label));
    panel.add(field);
    return field;
  }

  public static void createSellingPanel() {
    JPanel sellingPanel = new JPanel(new GridLayout(0, 1));
    JTextField clientPhoneNo = createField(sellingPanel, "clientPhoneNo");
    JTextField clientId = createField(sellingPanel, "clientId");
    JTextField clientCity = createField(sellingPanel, "clientCity");
    JTextField clientName = createField(sellingPanel, "clientName");
    JTextField productQuantity = createField(sellingPanel, "sold Quantity");
    JTextField productId = createField(sellingPanel, "productId");

    int result = JOptionPane.showConfirmDialog(
      null,
      sellingPanel,
      "Selling transaction",
      JOptionPane.OK_CANCEL_OPTION,
      JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
      Client newClient = new Client(
        Integer.parseInt(clientPhoneNo.getText()),
        clientCity.getText(),
        clientName.getText(),
        Integer.parseInt(clientId.getText())
      );

      Sale newSale = new Sale(
        java.time.LocalDateTime.now(),
        Integer.parseInt(productQuantity.getText())
      );
      SaleTransactionsService.insertNewSaleTransaction(
        newSale,
        newClient,
        Integer.parseInt(productId.getText())
      );
    }
  }
}
