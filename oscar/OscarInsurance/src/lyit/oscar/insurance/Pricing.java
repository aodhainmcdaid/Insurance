package lyit.oscar.insurance;
import java.util.ArrayList;
//imports
import java.util.Random;

/**
 * @author Melissa Melaugh
 */
public class Pricing {
	
	//Variables
	private double price;
    
    double INITIALPRICE= 700.00;
	
	/**
	 * The constructor for the pricing class
	 * @param aUser2	this is the current User2
	 */
	public Pricing()
	{
		price = INITIALPRICE;
	}
	
	/**
	 * This method looks at the current User2 and generates a price based on their data.
	 * If they wish to purchase, it generates a policy number and updates the User2's information.
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
	 * This method generates a unique policy number for the User2 between 100000000 and 999999999. 
	 * It updates the User2's profile with their unique policy number.
	 */
	public int generatePolicyNum(){
		int polNum = 0;
		
		//Generates the policy number
			Random rnd = new Random();
			polNum = rnd.nextInt(899999) + 100000; 	
			
			return polNum;			
	}
	
}
