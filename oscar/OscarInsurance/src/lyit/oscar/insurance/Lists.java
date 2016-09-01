package lyit.oscar.insurance;

public class Lists {
	//Variables
	static private User[] allUsers = {};
	
	/**
	 * This method returns the user list if the class or user has the privilege to see them, or a blank list if they don't.
	 * 
	 * @param priv	The privilege level of the caller
	 * @return		The user list based on privilege
	 */
	static public User[] getUserList(Boolean priv){
		if(priv){
			return allUsers;
		}else{
			User[] noUsers = {};
			return noUsers;
		}
	}
	
}
