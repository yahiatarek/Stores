package database;

import Product.Product;
import Sale_transactions.Supplier;
import Store.Store;
import database.SQLServerConnection;
import java.sql.*;

public class ShopService {

  public static void insertProductIntoDatabase(Product product) {
    String queryString =
      " insert into product.product (product_cost, product_price, product_quantity, product_name, store_id)" +
      " values (?, ?, ?, ?, ?)";
    try (
      Connection connection = SQLServerConnection.openSqlServerConnection();
      PreparedStatement prepsInsertProduct = connection.prepareStatement(
        queryString
      );
    ) {
      prepsInsertProduct.setDouble(1, product.productCost);
      prepsInsertProduct.setDouble(2, product.productPrice);
      prepsInsertProduct.setDouble(3, product.productQuantity);
      prepsInsertProduct.setString(4, product.productName);
      prepsInsertProduct.setInt(5, product.productStoreId);
      // Retrieve the generated key from the insert.
      prepsInsertProduct.execute();
    } catch (SQLException err) {
      System.err.println("Error connecting to the database");
      err.printStackTrace(System.err);
      System.exit(0);
    }
  }

  public static void insertStoreIntoDatabase(Store store) {
    String queryString =
      " insert into store.store (store_address, store_phone_no, store_name)" +
      " values (?, ?, ?)";
    try (
      Connection connection = SQLServerConnection.openSqlServerConnection();
      PreparedStatement prepsInsertProduct = connection.prepareStatement(
        queryString
      );
    ) {
      prepsInsertProduct.setString(1, store.storeAddress);
      prepsInsertProduct.setInt(2, store.storePhoneNo);
      prepsInsertProduct.setString(3, store.storeName);
      // Retrieve the generated key from the insert.
      prepsInsertProduct.execute();
    } catch (SQLException err) {
      System.err.println("Error connecting to the database");
      err.printStackTrace(System.err);
      System.exit(0);
    }
  }

  public static void insertSupplierIntoDatabase(Supplier supplier) {
    String queryString =
      " insert into sale.supplier (supplier_address, supplier_phone_no, supplier_name)" +
      " values (?, ?, ?)";
    try (
      Connection connection = SQLServerConnection.openSqlServerConnection();
      PreparedStatement prepsInsertProduct = connection.prepareStatement(
        queryString
      );
    ) {
      prepsInsertProduct.setString(1, supplier.supplierAddress);
      prepsInsertProduct.setInt(2, supplier.supplierPhoneNo);
      prepsInsertProduct.setString(3, supplier.supplierName);
      // Retrieve the generated key from the insert.
      prepsInsertProduct.execute();
    } catch (SQLException err) {
      System.err.println("Error connecting to the database");
      err.printStackTrace(System.err);
      System.exit(0);
    }
  }
}
