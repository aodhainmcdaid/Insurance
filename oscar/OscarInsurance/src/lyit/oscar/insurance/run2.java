package lyit.oscar.insurance;
import java.util.*;
import java.sql.Connection;
//Run2 created to account for problems in original
import java.util.*;


public class run2 {

	private User aUser;
	private Admin anAdmin;
	
	
	String AdminPass= "pass";
	String UserPass= "pass2";
	Scanner keyIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run3();
		
	}
	public static void run3() {
	    /*Connection conn = null;
		System.out.println("Starting Connection to DB");
		conn = MYSQLconnect.getConnection();
		
		System.out.println("Created Connection \n");
		//Prompt user
*/		Scanner keyIn = new Scanner(System.in);
		
		System.out.println("1. Customer Menu");
		System.out.println("2. Admin Menu");
		System.out.println("3. Exit");
		
		System.out.println("Enter Option: ");
		int userIn= keyIn.nextInt();
		
		if(userIn==1)
		{
			//Customer display
			System.out.print("Hello World");
			displayClientMenu();		
		}
		
		else if(userIn==2)
		{
			displayAdminMenu();
		}
		else if(userIn==3)
		{
			System.exit(0);
		}
		else
		{
			System.out.println("Wrong Input!");
			run3();
		}
		
	
	}
			
		public static void displayAdminMenu()
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n\n\t*************\n");
		    System.out.println("\n\tAdmin Menu");
		    System.out.println("\t*************\n");
		    System.out.println("1.\tView Policy");
		    System.out.println("2.\tUpdate cutomer");
		    System.out.println("3.\tDelete customer");
		    System.out.println("0.\tExit\n\n");   
		    
		    System.out.print("Select Option: ");
		    int userIn= sc.nextInt();
		    
		    if (userIn==1) {
		        //method1;
		    }
		    if (userIn==2) {
		        //method1;
		    }
		    if (userIn==3) {
		        //method1;
		    }
		    if (userIn==0) {
		    	run3();
		    }
		}
		
		/**
		 * 
		 * @return display login for customer
		 */
		public static void displayClientMenu()
		{
			Scanner sc = new Scanner(System.in);
		    System.out.println("\n\tUser Insurance Menu");
		    System.out.println("\t-------------------");
		    System.out.println("1.\tCreate New Policy");
		    System.out.println("2.\tView Policy");
		    System.out.println("3.\tCancel Policy");
		    System.out.println("0.\tExit\n\n");   
		  
		    System.out.print("Select Option: ");
		    int userIn= sc.nextInt();
		    
		    if (userIn==1) {
		        System.out.println("Hello Ruth");;
		    }
		    if (userIn==2) {
		        //method1;
		    }
		    if (userIn==3) {
		        //method1;
		    }
		    if (userIn==0) {
		    	run3();
		    }
		}

}
