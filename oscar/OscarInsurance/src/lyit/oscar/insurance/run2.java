/**
 * @authors
 *  Melissa and Daniela
 * 	Aodhain McDaid
 *  Fred Manu
 */

package lyit.oscar.insurance;

import java.util.InputMismatchException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//Run2 created to account for problems in original


public class run2 {


	//private User aUser;
  	//User2 user;


	String AdminPass= "pass";
	String UserPass= "pass2";

	//Scanner keyIn;
	 //static SqlStatements sqlEngine = new SqlStatements(); 
	
	

	public static void run3() 
	{
		
		Scanner keyIn = new Scanner(System.in);
		Connection conn = null;
		System.out.println("Starting Connection to DB");
		//conn = MYSQLconnect.getConnection();
		
		System.out.println("Created Connection \n");
		int option;
		do{
			System.out.println("\n1. Customer Menu\n2. Admin Menu\n0. Exit");
			System.out.println("\nEnter Option: ");

			option = keyIn.nextInt(); 
			

			switch(option)
			{
			case 1: //open account
				displayClientMenu();	
				int numb = getNumResponse("\nEnter option",0,2);                    

				switch(numb)
				{
				case 1:                                           
					User2 client = createUser();
					User2 client2 = List2.addUser(client);
					policyDetails policy1 = List2.getPolicyDetails();
               System.out.println(" Your policy Number is: " +policy1.getPolicyID());
					System.out.println("Added!");
               System.out.println(policy1);
               System.out.println(client2);
               
					//sqlEngine.insertCust(client2);          
					//sqlEngine.insertPol(polNo);
					
					break;

				case 2: 
					String numb2 = getStrResponse("\nEnter your Policy Number: ");
					User2 client3 = List2.viewPolicy(numb2);
					if(client3 != null)
					{
						//User2 client4 = sqlEngine.selectCust(client3);
                  System.out.println("start printing");
						System.out.println(client3);
						
					}
					else
					{
						System.out.println("Policy Number invalid..Can't view your details");
					}
					break;

				case 0: 	
					System.out.println("Thank you..");
					break;  

				default:	System.out.println("Invalid Customer option entered " );            
				} //end switch 2                                        						
				break;		

			case 2: //close account
				displayAdminMenu();
				int numb2 = getNumResponse("\nEnter option",0,3);                    

				switch(numb2)
				{
				case 1:

					String numb3 = getStrResponse("\nEnter Client Policy Number: ");
					User2 client2 = List2.viewPolicy(numb3);
					if(client2 != null)
					{
						//User2 client3 = sqlEngine.selectCust(client2);
						//List2.displayUser(client3);
					}
					else
					{
						System.out.println("Policy Number invalid..Can't view client details");
					}                                 
					break;

				case 2: 
					break;

				case 3: 	
					String numb4 = getStrResponse("\nEnter Client Policy Number: ");
					User2 client4 = List2.deleteUser(numb4);
					if(client4 != null)
					{
						//sqlEngine.delCust(client4);
					}
					else
					{
						System.out.println("Policy Number is invalid..Can't delete client");
					}                              
					break;

				case 0: 	
					System.out.println("Thank you Adminstrator..");
					break;  

				default:	
					System.out.println("Invalid  Admin option entered" );            
				} //end switch 3                                        						
				break;		              						

			case 0: 	
				System.out.println("Goodday..");
				break;  

			default:	
				System.out.println("Invalid option entered " );			
			}//end switch 1
		
		}while(option !=0);
			
	}		
	/**
	 * 
	 * @return display login for customer
	 */
	public static void displayClientMenu()
	{
		System.out.println("\n\tUser Insurance Menu");
		System.out.println("\t-------------------");
		System.out.println("1.\tCreate New Policy");
		System.out.println("2.\tView Policy");
		System.out.println("0.\tExit\n\n");  
	}
	
	/**
	 * 
	 * @return display login for Admin
	 */
	public static void displayAdminMenu()
	{			
		System.out.println("\n\n\t*************\n");
		System.out.println("\n\tAdmin Menu");
		System.out.println("\t*************\n");
		System.out.println("1.\tView Policy");
		System.out.println("2.\tUpdate cutomer");
		System.out.println("3.\tDelete customer");
		System.out.println("0.\tExit\n\n");   
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
		return response;
		 
		}
	/**
	 * Creates a new user based on information that the user provides, and then updates the current user to the newly
	 * created one from this method.
	 */
/*	public static User2 createUser(){
		//Create the title name, and user's full name
		String sn = getStrResponse("Please input your title then hit enter: ");
		String first = getStrResponse("Please input your first name then hit enter: ");
		String last = getStrResponse("Please input your last name then hit enter: ");
		String phone = getStrResponse("Please input your last name then hit enter: ");
		String email = getStrResponse("Please input your last name then hit enter: ");
		String address = getStrResponse("Please input your last name then hit enter: ");
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
		}*/

		public static User2 createUser(){
			//Create the title name, and user's full name
			
			String title = getStrResponse("Please input your title: ");
			String first = getStrResponse("Please input your first name: ");
			String last = getStrResponse("Please input your last name: ");
			String phone = getStrResponse("Please input your phone: ");
			String email = getStrResponse("Please input your email: ");
			String address = getStrResponse("Please input your address: ");
			
			//String policyNo= "1";
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

			/*//Create the user's password - note this should be turned into a 
			String password = getStrResponse("Please enter a password then hit enter: ");
			int hashedPassword = password.hashCode();
	*/
			int gender = getNumResponse("Please chose you gender: \n\t1: Male \n\t2:Female", 1, 2);
			String a_gender = "";
			if(gender == 1){
				a_gender = "Male";
			}else{
				a_gender = "Female";
			}

			//Choose policy Type 
			//int polType = 2;
			
			
			//Create the user based on the given information
			//String polNum  = policyId();
			User2 aNewUser = new User2(title, first, last, birthday, phone, a_gender,email, address);
			
			// TODOwill have to work on the policy number. run 1 has nice codes. this is dummy
			//Pricing priceUser = new Pricing(aNewUser); 
			aNewUser.setPersonID();
			aNewUser.getAge();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					
			System.out.print("Select Policy Type: ");
			String type = getStrResponse("1)Partial Coverage 2)Full Coverage: ");
			String startdate=getStrResponse("Enter Policy start Date in this format (yyyy-MM-dd): ");
			LocalDate start =LocalDate.parse(startdate,dtf);
			String enddate=getStrResponse("Enter Policy end Date in this format (yyyy-MM-dd):: ");
			LocalDate end =LocalDate.parse(enddate,dtf);
			String pay_type = getStrResponse("Enter payment type: ");
			
			
			policyDetails aNewPolicy= new policyDetails(type, start, end, pay_type);
			
			aNewPolicy.generatePolicyID();
        
			List2.addPolicy(aNewPolicy);
         aNewUser.setPolicyNo(Integer.toString(aNewPolicy.getPolicyID()));
			

			
			//List2.addUser(aNewUser);
			//System.out.print("aaa");
			return aNewUser;
		}

	// //TODO:Returns policy type
// 	public static int policy()
// 	{
// 		return 0;
// 	}
// 	//TODO
// 	public static String policyId()
// 	{
// 		return "555555";
// 	}
// 

}
