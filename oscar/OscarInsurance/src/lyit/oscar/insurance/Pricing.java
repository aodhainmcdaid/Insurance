package lyit.oscar.insurance;
import java.util.ArrayList;
//imports
import java.util.Random;

/**
 * Generates price based on age and policy numbers
 * @author Melissa, Daniela, Aodhain, and Fred
 */
public class Pricing {
	
	//Variables
	private double price;
    double INITIALPRICE= 700.00;
	
	/**
	 * The constructor for the pricing class
	 */
	public Pricing()
	{
		price = INITIALPRICE;
	}
	
	/**
	 * This method looks at the user's age and returns the price based on the age input
	 * @param userAge	The age of the policy holder
	 * @return 			The price of the policy as a Double
	 */
	public double  generatePrice(int userAge)
	{						
		if (userAge >=60)
			price=1000;
		if (userAge>=50)
			price=800;
		if (userAge>=40)
			price=700;
		if (userAge>=30)
			price=600;
		if(userAge>=18)
		    price=500;
		else System.out.print("under 18 not able to be a policy holder ");
		
		return price;
	}
	
	/**
	 * This method generates a unique policy number for the User2 between 100000 and 999999.
	 * @return the generated policy number as an int
	 */
	public int generatePolicyNum(){
		Random rnd = new Random();
		int polNum = rnd.nextInt(899999) + 100000; 	
		
		return polNum;			
	}
	
}
