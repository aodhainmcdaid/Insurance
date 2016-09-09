package lyit.oscar.insurance;

//import java.time.LocalDateaa;

public class Admin extends User {
	
	private String firstName;
	private String lastName;
	
	
	Admin(String firstNameIn, String lastNameIn) 
	{
		super(firstNameIn, lastNameIn);
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
