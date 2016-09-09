package lyit.oscar.insurance;

import java.time.LocalDate;

public class Admin extends User {
	/**
	 * TODO: Generate Admin Methodsa
	 */
	
	/**
     * This class contains important user information
     * 
     * @param sn	The user's chosen screen name
     * @param first	The user's first name
     * @param last	The user's last name
     * @param anAge	The user's age
     * @param pass	The user's chosen password
     * @param ad	The user's administration privilege - should always be false unless creating a new user from the Admin Class
     */
	Admin(String sn, String first, String last, LocalDate bDay, int pass, String gender) {
		super(sn, first, last, bDay, pass, true, gender);
		
	}
	
	public void upgradeToAdmin(User user){
		//TODO: Get all the information from the user, delete the user from the main list, re-add the user only as an Admin Object.
		
	}
	
	public void searchUsers(){
		//TODO: Allows an admin to search the entire list of users.
		//Note: the search below is only an example, although users can be searched for by full name, first name, last name or screen name
		String search = Run.getStrResponse("Enter the full name of the user you are looking for");
	}

}
