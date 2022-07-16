package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Connect to SQL Server, execute a SELECT query, print the results.
 *
 */
public class SelectFromSQLServer {
  //The SQL Server JDBC Driver is in
  //C:\Program Files\Microsoft JDBC Driver 6.0 for SQL Server\sqljdbc_6.0\enu\auth\x64
  private static final String jdbcDriver =
    "com.microsoft.sqlserver.jdbc.SQLServerDriver";

  //The JDBC connection URL which allows for Windows authentication is defined below.
  private static final String jdbcURL = "jdbc:sqlserver://localhost:1433;";

  //To make Windows authentication work we have to set the path to sqljdbc_auth.dll at the command line

  /**
   * main method.
   *
   * @param  args  command line arguments
   */
  public static void main(String[] args) {
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
      System.out.println(
        "\nParentOrganizationName\t|\tOrganizationName\t|\tCurrencyName"
      );
      System.out.println(
        "----------------------\t|\t----------------\t|\t------------"
      );

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
}
