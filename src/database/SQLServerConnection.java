package database;

import java.sql.*;
import java.util.Properties;

/**
 * Connect to SQL Server, execute a SELECT query, print the results.
 *
 */
public class SQLServerConnection {
  private static final String jdbcURL =
    "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=Store";

  public static Connection openSqlServerConnection() throws SQLException {
    Properties properties = new Properties();
    properties.put("user", "sa");
    properties.put("password", "123456");
    Connection databaseConnection = DriverManager.getConnection(
      jdbcURL,
      properties
    );
    System.out.println("Connected to the database");
    return databaseConnection;
  }

  public static void printResultSetRow(ResultSet rs) throws SQLException {
    //Use the column name alias as specified in the above query
    String sale_id = rs.getString("sale_id");
    String sale_date = rs.getString("sale_date");
    String sale_product_quantity = rs.getString("sale_product_quantity");
    System.out.println(
      sale_id + "\t|\t" + sale_date + "\t|\t" + sale_product_quantity
    );
  }
}
