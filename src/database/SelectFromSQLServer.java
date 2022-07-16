package database;

import java.sql.*;
import java.util.Properties;

/**
 * Connect to SQL Server, execute a SELECT query, print the results.
 *
 */
public class SelectFromSQLServer {
  //The JDBC connection URL which allows for Windows authentication is defined below.
  private static final String jdbcURL =
    "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=Store";

  //To make Windows authentication work we have to set the path to sqljdbc_auth.dll at the command line

  /**
   * main method.
   *
   * @param  args  command line arguments
   */
  public static void runSqlServerConnection() {
    System.out.println("Program started");
    Connection databaseConnection = null;
    try {
      //Connect to the database
      Properties properties = new Properties();
      properties.put("user", "sa");
      properties.put("password", "123456");
      databaseConnection = DriverManager.getConnection(jdbcURL, properties);
      System.out.println("Connected to the database");

      //declare the statement object
      Statement sqlStatement = databaseConnection.createStatement();

      //declare the result set
      ResultSet rs = null;

      //Build the query string, making sure to use column aliases
      String queryString =
        "select sale_id, sale_date, sale_product_quantity from sale.sale";

      //print the query string to the screen
      System.out.println("\nQuery string:");
      System.out.println(queryString);

      //execute the query
      rs = sqlStatement.executeQuery(queryString);

      //print a header row
      System.out.println("\nsale_id\t|\tsale_date\t|\tsale_product_quantity");
      System.out.println("---------\t|\t---------\t|\t----------------------");

      //loop through the result set and call method to print the result set row
      while (rs.next()) {
        printResultSetRow(rs);
      }

      //close the result set
      rs.close();
      System.out.println("Closing database connection");

      //close the database connection
      databaseConnection.close();
    } catch (SQLException err) {
      System.err.println("Error connecting to the database");
      err.printStackTrace(System.err);
      System.exit(0);
    }
    System.out.println("Program finished");
  }

  /**
   * Prints each row in the ResultSet object to the screen.
   *
   * @param  rs  the result set from the SELECT query
   * @throws SQLException SQLException thrown on error
   */
  public static void printResultSetRow(ResultSet rs) throws SQLException {
    //Use the column name alias as specified in the above query
    String sale_id = rs.getString("sale_id");
    String sale_date = rs.getString("sale_date");
    String sale_product_quantity = rs.getString("sale_product_quantity");
    System.out.println(
      sale_id + "\t|\t" + sale_date + "\t|\t" + sale_product_quantity
    );
  }

  // to get database schemas
  private static void executeGetSchemas(Connection con) {
    try {
      DatabaseMetaData dbmd = con.getMetaData();
      ResultSet rs = dbmd.getSchemas();
      ResultSetMetaData rsmd = rs.getMetaData();

      // Display the result set data.
      int cols = rsmd.getColumnCount();
      while (rs.next()) {
        for (int i = 1; i <= cols; i++) {
          System.out.println(rs.getString(i));
        }
      }
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
