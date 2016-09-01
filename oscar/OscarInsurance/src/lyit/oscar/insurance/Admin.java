package lyit.oscar.insurance;

public class Admin extends User {
	/**
	 * TODO: Generate Admin Methods
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
	Admin(String sn, String first, String last, int anAge, String pass) {
		super(sn, first, last, anAge, pass, true);
		
	}

}
