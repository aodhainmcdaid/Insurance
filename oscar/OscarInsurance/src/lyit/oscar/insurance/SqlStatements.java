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

	//insert customer into the database
	public void insertCust(User aUser, PolicyDetails aPolicy)
	{
		PreparedStatement statement = null;
		Connection connection = null;
		PreparedStatement statement2 = null;


		try {
			connection = MYSQLconnect.getConnection();
			String addCust = "INSERT INTO person_table (idperson_table,title,First_name,Surname,Date_of_birth,"+
					"telephone,gender,email,address) VALUES (?,?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(addCust);
			statement.setInt(1, aUser.getPersonID());
			statement.setString(2, aUser.getTitle());
			statement.setString(3, aUser.getFname());
			statement.setString(4, aUser.getlname());
			statement.setDate(5, Date.valueOf(aUser.getDOB()));
			statement.setString(6, aUser.getPhone());
			statement.setString(7, aUser.getGender());
			statement.setString(8, aUser.getEmail());
			statement.setString(9, aUser.getAddress());

			int insertRows = statement.executeUpdate();
			if (insertRows > 0) {
				System.out.println("\nPolicy accepted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			connection = MYSQLconnect.getConnection();
			String addPolicy = "INSERT INTO policy_table (idpolicy,cover_start,cover_finish,payment_type,"+
					"cost,idperson_table) VALUES (?,?,?,?,?,(SELECT idperson_table FROM person_table WHERE idperson_table = ?))";

			statement2 = connection.prepareStatement(addPolicy);
			statement2.setInt(1, aPolicy.getPolicyID());
			statement2.setDate(2, Date.valueOf(aPolicy.getPolicyStart()));
			statement2.setDate(3, Date.valueOf(aPolicy.getPolicyEnd()));
			statement2.setString(4, aPolicy.getPaymentType());
			statement2.setDouble(5, aPolicy.getPolicyCost());
			statement2.setInt(6, aUser.getPersonID());

			int insertRows = statement.executeUpdate();
			if (insertRows > 0) {
				System.out.println("\nPolicy accepted and Activated!\nPolicy number is: "+aPolicy.getPolicyID());
			}   
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					statement2.close();
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
			String addCust = ("DELETE FROM person_table WHERE idperson_table = ?");
			statement = connection.prepareStatement(addCust);
			statement.setInt(1, aUser.getPersonID());
			int deleteRows = statement.executeUpdate();
			if(deleteRows > 0)
			{
				System.out.println("DELETED: "+aUser.getFname() +""+aUser.getlname()+"  policy number "+aUser.getPolicyNo());
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

	//view a specific customer detail
	public User selectCust(User aUser)
	{
		ResultSet selectResult = null;
		Connection connection = null;
		PreparedStatement statement = null;
		User newUser = new User();


		try {
			connection = MYSQLconnect.getConnection();
			String addCust = ("SELECT *,policy_table.idpolicy  FROM person_table, policy_table WHERE policy_table.idperson_table = ?");
			statement = connection.prepareStatement(addCust);
			statement.setInt(1, aUser.getPersonID());
			selectResult = statement.executeQuery();
			while (selectResult.next()) {

				//newUser.setPersonID(selectResult.getInt("idperson_table"));
				newUser.setTitle(selectResult.getString("title"));
				newUser.setFname(selectResult.getString("first_Name"));
				newUser.setlname(selectResult.getString("surname"));
				newUser.setDOB((selectResult.getDate("date_of_birth")).toLocalDate());
				newUser.setPhone(selectResult.getString("phone"));
				newUser.setGender(selectResult.getString("gender"));
				newUser.setEmail(selectResult.getString("email"));
				newUser.setAddress(selectResult.getString("address"));
				newUser.setPolicyNo(Integer.toString(selectResult.getInt("idpolicy_table")));

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
