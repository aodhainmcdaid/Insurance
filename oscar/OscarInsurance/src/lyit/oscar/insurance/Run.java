package lyit.oscar.insurance;

import java.util.InputMismatchException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Melissa and Daniela
 */
public class Run {
	private User aUser;
	private Admin anAdmin;

	//private passwrd= "password";
	
	
	
	/**
	 * This method runs the main program. It first starts the data base and then it prompts the user.
	 * It runs based off the user choice
	 * 
	 * @return Returns 1 for testing purposes to show that it ran properly
	 */
	public int run() {
	    Connection conn = null;
		System.out.println("Starting Connection to DB");
		conn = MYSQLconnect.getConnection();
		
		System.out.println("Created Connection \n");

		//Prompt user
		int hold = getNumResponse("Please select an option: \n\t1: Log In \n\t2: Create New User", 1, 2);
		System.out.println("Response = " + hold);
		if(hold == 1){
			logon();
		}else if(hold == 2){
			aUser = createUser();
		}
		
		if(aUser.getAdmin()){ 
			adminRun();
		}else{
			userRun();
		}
		
		return 1;
	}
	
	/**
	 * This method will log the user on
	 */
	public void logon(){
		//Temporary fix- will be modified later
		String uname="u";
		String pass="u";
		
		String aname="a";
		String apass="a";
		
		
		System.out.print("Enter Username");
		{
			if(uname=="u")
			{	
				
				
			}
			
			
			
			
		}
		
		
		
		
		
	}
	
	/**
	 * This method allows the user to do limited things with their account - either purchase a policy if there isn't 
	 * a policy already purchased, or view the policy that they have.
	 */
	public void userRun(){
			System.out.print("__________"+"User Menu"+"___________");

	}
	
	/**
	 * This method allows the admin to do what they would like, such as update user information, change users from normal
	 * users to admins, as well as view and search the entire list of users in the database.
	 */
	public void adminRun(){
		//TODO: Generate what the Admin can do once logged in
	}
	
	/**
	 * Gets a user response from the given instructions
	 * @param aString	The instructions for what is wanted
	 * @param min		The minimum the number returned can be
	 * @param max		The maximum the number returned can be
	 * @return			The User's correct input
	 */
	static public int getNumResponse(String aString, int min, int max){
		//variables
		int response = min - 3; //make sure that the default response cannot be marked as valid
		Scanner in = new Scanner(System.in);
		Boolean noResponse = true;
		
		//Ask the user for their input
		while(noResponse){
			System.out.println(aString);
			try{
				response = in.nextInt();
				if(response >= min && response <= max){
					noResponse = false; //You have a response if the given number is between the min and max given
				}else{
					System.out.println("Invalid Response.");
				}
			}catch(InputMismatchException e){
				in.next();
				System.out.println("Bad Response");
			}
		}
		
		//close the scanner down and return the response
		in.close(); 
		return response;
	}

	/**
	 * Gets a user response from the given instructions
	 * @param aString	The instructions for what is wanted
	 * @return 		The correct response from the user
	 */
	static public String getStrResponse(String aString){
		String response = "";
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println(aString);
			response = input.next();
			String hold = "Is " + response + " correct? \n\t1: Yes \n\t2: No";
			int ans = getNumResponse(hold, 1, 2);
			if(ans == 1){
				break;
			}
		}
		//input.close();
		return response;
	}
	
	/**
	 * Creates a new user based on information that the user provides, and then updates the current user to the newly
	 * created one from this method.
	 */
	public User createUser(){
		//Create the screen name, and user's full name
		String sn = getStrResponse("Please input your screenname then hit enter: ");
		String first = getStrResponse("Please input your first name then hit enter: ");
		String last= getStrResponse("Please input your last name then hit enter: ");
		LocalDate birthday = LocalDate.now();
		
		//Create the User's Birthday
		while(true){
			//Ask user for the year and month of their DOB
			int year = getNumResponse("Please input the year you were born: ", 1900, LocalDate.now().getYear());
			int month = getNumResponse("Please input the number of the month you were born: ", 1, 12);
			
			//update birthday with the year and the month
			birthday = LocalDate.of(year, month, 1);
			
			//update max day to the length of the birth month so that the user cannot input a number outside of this range
			int maxDay = birthday.lengthOfMonth();
			
			//ask for the user's day
			int day = getNumResponse("Please enter the day you were born: ", 1, maxDay);
			
			//update Birthday
			birthday = LocalDate.of(year, month, day);
			
			String hold = "Is your birthday " + birthday.getDayOfMonth() + " of " + birthday.getMonth() + birthday.getYear() +"? "
					+ "\n\t1: Yes \n\t2: No";
			int response = getNumResponse(hold, 1, 2);
			
			if(response == 1){
				break;
			}
		}
		
		//Create the user's password - note this should be turned into a 
		String password = getStrResponse("Please enter a password then hit enter: ");
		int hashedPassword = password.hashCode();
		
		int gender = getNumResponse("Please chose you gender: \n\t1: Male \n\t2:Female", 1, 2);
		String a_gender = "";
		if(gender == 1){
			a_gender = "Male";
		}else{
			a_gender = "Female";
		}
		
		//Create the user based on the given information
		User aNewUser = new User(sn, first, last, birthday, hashedPassword, false, a_gender);
		Lists.addUser(aNewUser);
		return aNewUser;
	}
	
	
	/**
	 * This method is to shut down the program - Closing connections to the Database will be done here.
	 */
	public void shutdown() {
		// TODO Auto-generated method stub
		//needs to close down the database connection
	}

}
