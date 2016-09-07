package lyit.oscar.insurance;

import java.util.InputMismatchException;
import java.time.LocalDate;
import java.util.Scanner;

public class Run {
	private User aUser;
	private Admin anAdmin;

	public int run() {
		//TODO: Start the Database
		//TODO: Initialize lists 
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
			
		}
		
		return 1;
	}
	
	public void logon(){
		//TODO: Get the user to enter their screen name, search the list for that screen name, produce an error if no screen name exists
		//TODO: After the user is seen to exist, ask them for the password, turn it to a hash and use the logon for the user
		//TODO: If password fails, make them start over from the beginning of the program else make aUser = the user details
		//TODO: Make sure to check if the User is an Admin object or a User object so that the admins will have access to their admin privileges
	}
	
	public void userRun(){
		//TODO: Generate what the User can do once logged in
	}
	
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
		input.close();
		return response;
	}
	
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
		
		//Create the user based on the given information
		User aNewUser = new User(sn, first, last, birthday, hashedPassword, false);
		Lists.addUser(aNewUser);
		return aNewUser;
	}
	
	
	
	public void shutdown() {
		// TODO Auto-generated method stub
		//needs to close down the database connection
	}

}
