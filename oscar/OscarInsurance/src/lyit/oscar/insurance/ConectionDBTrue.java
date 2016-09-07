package lyit.oscar.insurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc. Driver;

public class ConectionDBTrue {
	public static void startDB() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance_schema,user=root&password=francesca12");
			String connectionUrl = "jdbc:mysql://localhost:3306/insurance_schema?autoReconnect=true&useSSL=false";
			String connectionUser = "root";
			String connectionPassword = "francesca12";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT  idPerson,First_name,Surname FROM person_table");
			while (rs.next()) {
				String id = rs.getString("idPerson");
				String firstName = rs.getString("First_name");
				String lastName = rs.getString("Surname");
				System.out.println("idPerson: " + id+ ", First Name: " + firstName
						+ ", Last Name: " + lastName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}
