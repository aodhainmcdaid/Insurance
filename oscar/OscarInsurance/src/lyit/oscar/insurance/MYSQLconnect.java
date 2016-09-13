// Daniela Pricope using http://theopentutorials.com/post/uncategorized/jdbc-mysql-connection-tutorial/
package lyit.oscar.insurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Daniela
 */
public class MYSQLconnect {
    //static reference to itself
    private static  MYSQLconnect instance = new  MYSQLconnect();
    public static final String URL = "jdbc:mysql://localhost:3306/insurance2?autoReconnect=true&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD ="password";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
     
    /**
     * Private constructor
     */
    MYSQLconnect() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
     /**
      * This method creates the connection if possible and prints out an error if it isn't possible. 
      * @return  The current connection - null if unable to connect.
      */
    private Connection createConnection() {
 
        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Connected to Database.");
            
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    /**
     * This method gets the current connection
     * @return The current connection created by the create connection method
     */
    public static Connection getConnection() {
        return instance.createConnection();
    }
}
