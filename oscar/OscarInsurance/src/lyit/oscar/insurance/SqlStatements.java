/**
 * @author Melissa and Daniela
 * 	Aodhain McDaid
 *  Fred Manu
 */
package lyit.oscar.insurance;


import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;


public class SqlStatements
{
	//insert customer into the databaseAA
	public void insertCust(User aUser)
	{
		PreparedStatement statement = null;
		Connection connection = null;


		try {
			connection = MYSQLconnect.getConnection();
			String addCust = "INSERT INTO person_table (personID,title,First_name,Surname,Date_of_birth, Telephone,Gender," + 
					"Email,Address,policyID) VALUES (?,?,?,?,?,?,?,?,?,?)";

			statement = connection.prepareStatement(addCust);
			//statement.setString(1, aUser.get);
			statement.setString(1, aUser.getTitle());
			statement.setString(2, aUser.getFname());
			statement.setString(3, aUser.getlname());
			statement.setDate(4, Date.valueOf(aUser.getDOB()));
			statement.setString(5, aUser.getPhone());
			statement.setString(6, aUser.getGender());
			statement.setString(7, aUser.getEmail());
			statement.setString(8, aUser.getAddress());
			statement.setString(9, aUser.getPolicyNo());
			

			int insertRows = statement.executeUpdate();
			if (insertRows > 0) {
				System.out.println("\nPolicy accepted and Activated!\nPolicy number is: "+aUser.getPolicyNo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//delete customer from database
	public void delCust(User aUser)
	{
		Connection connection = null;
		PreparedStatement statement = null;


		try {
			connection = MYSQLconnect.getConnection();
			String addCust = ("DELETE FROM Customer WHERE policyNo = ?");
			statement = connection.prepareStatement(addCust);
			statement.setString(1, aUser.getPolicyNo());
			int deleteRows = statement.executeUpdate();
			if(deleteRows > 0)
			{
				System.out.println("DELETE FROM person WHERE policyNo = ?");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	//update customer details
	/*public void updateCust(User2 aUser)
	{
		Connection connection = null;
		PreparedStatement statement = null;


		try {
			connection = MYSQLconnect.getConnection();
			String addCust = ("UPDATE FROM Customer WHERE policyNo = ?");
			statement = connection.prepareStatement(addCust);
			statement.setString(1, aUser.getPolicyNo());
			int deleteRows = statement.executeUpdate();
			if(deleteRows > 0)
			{
				System.out.println("DELETE FROM person WHERE policyNo = ?");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}*/

	//view a specific customer details
	public User selectCust(User aUser)
	{
		ResultSet selectResult = null;
		Connection connection = null;
		PreparedStatement statement = null;
		User newUser = new User();


		try {
			connection = MYSQLconnect.getConnection();
			String addCust = ("SELETE * FROM Customer WHERE policyNo = ?");
			statement = connection.prepareStatement(addCust);
			statement.setString(1, aUser.getPolicyNo());
			selectResult = statement.executeQuery();
			while (selectResult.next()) {

				newUser.setTitle(selectResult.getString("title"));
				newUser.setFname(selectResult.getString("firstName"));
				newUser.setlname(selectResult.getString("lastName"));
				newUser.setDOB((selectResult.getDate("dob")).toLocalDate());
				newUser.setPhone(selectResult.getString("phone"));
				newUser.setGender(selectResult.getString("gender"));
				newUser.setEmail(selectResult.getString("email"));
				newUser.setAddress(selectResult.getString("address"));
				newUser.setPolicyNo(selectResult.getString("policyNo"));
				newUser.setPolicyType(selectResult.getInt("policyType"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return newUser;
	}
}
