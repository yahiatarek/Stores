package database;

import Product.Product;
import database.SQLServerConnection;
import java.sql.*;

public class shopService {

  public static void insertProductIntoDatabase(Product product) {
    String queryString =
      "INSERT INTO product.product" +
      "(product_id, product_cost, product_price, product_quantity, product_name, store_id)" +
      "VALUES (?,?,?,?,?,?)";
    int resultSet = 0;
    long id = 0;
    try (
      Connection connection = SQLServerConnection.openSqlServerConnection();
      PreparedStatement prepsInsertProduct = connection.prepareStatement(
        queryString,
        Statement.RETURN_GENERATED_KEYS
      );
    ) {
      System.out.println("Connected to the database");
      prepsInsertProduct.setInt(1, product.productID);
      prepsInsertProduct.setDouble(2, product.productCost);
      prepsInsertProduct.setDouble(3, product.productPrice);
      prepsInsertProduct.setString(4, product.productQuantity);
      prepsInsertProduct.setString(5, product.productName);
      prepsInsertProduct.setInt(6, product.productStoreId);
      // Retrieve the generated key from the insert.
      resultSet = prepsInsertProduct.executeUpdate();

      // Print the ID of the inserted row.
      if (resultSet > 0) {
        // get the ID back
        try (ResultSet rs = prepsInsertProduct.getGeneratedKeys()) {
          if (rs.next()) {
            id = rs.getLong(1);
          }
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
      }
      System.out.println(id);
    } catch (SQLException err) {
      System.err.println("Error connecting to the database");
      err.printStackTrace(System.err);
      System.exit(0);
    }
  }
}
