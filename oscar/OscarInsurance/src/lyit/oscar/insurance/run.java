package lyit.oscar.insurance;

import java.util.InputMismatchException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Melissa, Daniela, Aodhain, and Fred
 */
public class run {
	static Scanner keyIn;
	static SqlStatements sqlEngine = new SqlStatements(); 

	/**
	 * This method is used to run the main program. 
	 */
	public static void run3() 
	{
		//Initiate important variables
		keyIn = new Scanner(System.in);
		Connection conn = null;
		System.out.println("Starting Connection to DB");
		conn = MYSQLconnect.getConnection();
		System.out.println("Created Connection \n");
		
		int option;
		do{
			System.out.println("\n1. Customer Menu\n2. Admin Menu\n0. Exit");

			option = getNumResponse("Enter Option:", 0,2); 

			switch(option)
			{
				case 1: //open account
					displayClientMenu();	
					int numb = getNumResponse("\nEnter option",0,2);                    
	
					switch(numb)
					{
						case 1:                                           
							User client = createUser();
							User client2 = List.addUser(client);
							PolicyDetails policy1 = List.getPolicyDetails();
							System.out.println(" Your policy Number is: " +policy1.getPolicyID());
							System.out.println("Added!");
							System.out.println(policy1);
							System.out.println(client2);
		
							sqlEngine.insertCust(client2, policy1);          
		
							break;
		
						case 2: 
							String numb2 = getStrResponse("\nEnter your Policy Number: ");
							User client3 = List.viewPolicy(numb2);
							if(client3 != null)
							{
								User client4 = sqlEngine.selectCust(client3);
								System.out.println("start printing");
								System.out.println(client4);
		
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
							User client2 = List.viewPolicy(numb3);
							if(client2 != null)
							{
								User client3 = sqlEngine.selectCust(client2);
								List.displayUser(client3);
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
							User client4 = List.deleteUser(numb4);
							if(client4 != null)
							{
								sqlEngine.delCust(client4);
							}
							else
							{
								System.out.println("Policy Number is invalid. Cannot delete client");
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
					System.out.println("Good bye.");
					break;  
	
				default:	
					System.out.println("Invalid option entered " );			
			}//end switch 1
		}while(option !=0);
	}		
	
	/**
	 * This method prints out the options for the customer
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
	 * This method prints out the options for the admin
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
	 * This method prompts the user for an integer response and returns the value.
	 * @param aString	The prompt
	 * @param min		The minimum value the returned integer can be
	 * @param max		The maximum value the returned integer can be
	 * @return			The user's integer choice
	 */
	static public int getNumResponse(String aString, int min, int max){
		//variables
		int response = min - 3; //make sure that the default response cannot be marked as valid
		Boolean noResponse = true;
		 
		//Ask the user for their input
		while(noResponse){
			System.out.println(aString);
			try{
				response = keyIn.nextInt();
				if(response >= min && response <= max){
					noResponse = false; //You have a response if the given number is between the min and max given
				}else{
					System.out.println("Invalid Response.");
				}
			}catch(InputMismatchException e){
				keyIn.nextLine();
				System.out.println("Bad Response");
			}
		}
		return response;
	}

	/**
	 * This method prompts the user for a response, and returns the String they responded with
	 * @param aString	The prompt
	 * @return			The String value that the user entered
	 */
	static public String getStrResponse(String aString){
		String response = "";
		while(true){
			//Print out the prompt
			System.out.println(aString);
			//Get user input
			response = keyIn.nextLine();
			//Check that user input isn't empty
			if(!response.isEmpty()){
				break;
			}
		}
		return response;
	}
	
	/**
	 * This method creates a new user based on information that the user provides
	 * then updates the current user to the newly created one from this method.
	 * After the user is created, it prompts the new user to create a policy based on 
	 * the information they provided.
	 */
	public static User createUser(){
		User aNewUser = new User(null, null, null, null, null, null, null, null);
		//Create the title name, and user's full name
		while(true){
			String title = getStrResponse("Please input your title: ");
			String first = getStrResponse("Please input your first name: ");
			String last = getStrResponse("Please input your last name: ");
			String phone = getStrResponse("Please input your phone: ");
			String email = getStrResponse("Please input your email: ");
			String address = getStrResponse("Please input your address: ");
			
			//create a dummy date to be updated
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
			
			//Get gender from user
			int gender = getNumResponse("Please chose you gender: \n\t1: Male \n\t2:Female", 1, 2);
			String a_gender = "";
			if(gender == 1){
				a_gender = "Male";
			}else{
				a_gender = "Female";
			}
			
			//update user
			aNewUser = new User(title, first, last, birthday, phone, a_gender, email, address);
			
			int hold = getNumResponse("Is the information you entered above correct? \n\t1: Yes \n\t2: No", 1, 2);
			if(hold == 1){
				break;
			}
		}
		
		
		aNewUser.setPersonID();
		int age = aNewUser.getAge();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		//Set information for the policy
		System.out.print("Select Policy Type: ");
		String type = getStrResponse("\n\t1)Partial Coverage \n\t2)Full Coverage: ");
		String startdate=getStrResponse("Enter Policy start Date in this format (yyyy-MM-dd): ");
		LocalDate start =LocalDate.parse(startdate,dtf);
		String enddate=getStrResponse("Enter Policy end Date in this format (yyyy-MM-dd): ");
		LocalDate end =LocalDate.parse(enddate,dtf);
		String pay_type = getStrResponse("Enter payment type: ");

		//Create policy based on entered information
		PolicyDetails aNewPolicy= new PolicyDetails(type, start, end, pay_type);
		
		//Create policy price based on age
		Pricing price = new Pricing();
		int policy = price.generatePolicyNum();
		aNewPolicy.setPolicyID(policy);
		double policyPrice = price.generatePrice(age);
		aNewPolicy.setPolicyCost(policyPrice);
				
		//Add the user and their policy to the list
		List.addPolicy(aNewPolicy);
		aNewUser.setPolicyNo(Integer.toString(aNewPolicy.getPolicyID()));
		List.addUser(aNewUser);
		System.out.print("User and policy created.");
		
		return aNewUser;
	}
}
