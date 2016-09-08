// Daniela Pricope using http://theopentutorials.com/post/uncategorized/jdbc-mysql-connection-tutorial/
package lyit.oscar.insurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


 
public class MYSQLconnect {
    //static reference to itself
    private static  MYSQLconnect instance = new  MYSQLconnect();
    public static final String URL = "jdbc:mysql://localhost:3306/insurance_schema?autoReconnect=true&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD ="francesca12";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
     
    //private constructor
    MYSQLconnect() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
 
        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database.");
            
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }
}