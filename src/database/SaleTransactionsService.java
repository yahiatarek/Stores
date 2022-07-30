package database;

import Sale_transactions.Client;
import Sale_transactions.Sale;
import java.sql.*;

public class SaleTransactionsService {

  public static void insertNewSaleTransaction(
    Sale sale,
    Client client,
    int productId
  ) {
    String queryString =
      " SET IDENTITY_INSERT sale.sale ON; insert into sale.sale (sale_date, sale_product_quantity, product_id, client_id)" +
      " values (?, ?, ?, ?)";
    try (
      Connection connection = SQLServerConnection.openSqlServerConnection();
      PreparedStatement prepsInsertProduct = connection.prepareStatement(
        queryString
      );
    ) {
      prepsInsertProduct.setObject(1, sale.saleDate);
      prepsInsertProduct.setInt(2, sale.saleProductQuantity);
      prepsInsertProduct.setInt(3, productId);
      prepsInsertProduct.setInt(4, client.clientId);
      // Retrieve the generated key from the insert.
      prepsInsertProduct.execute();
    } catch (SQLException err) {
      System.err.println("Error connecting to the database");
      err.printStackTrace(System.err);
      System.exit(0);
    }
  }
}
