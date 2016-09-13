package lyit.oscar.insurance;
import java.util.ArrayList;
//imports
import java.util.Random;

/**
 * @author Melissa Melaugh
 */
public class Pricing {
	//Variables
	
	/**
	 * The constructor for the pricing class
	 * @param aUser2	this is the current User2
	 */
	public Pricing(){
	
	}
	
	/**
	 * This method looks at the current User2 and generates a price based on their data.
	 * If they wish to purchase, it generates a policy number and updates the User2's information.
	 */
	public double  generatePrice(int userAge){
		double price=0.0;
	    double DISCOUNT1=0.1;
	    double DISCOUNT2=0.15;
		
		double INITIALPRICE= 1000.00;
		if (userAge >=60)
			price=INITIALPRICE;
		else if (userAge>=50)
			price=price - price* DISCOUNT1;
		else if (userAge>=40)
			price=price-price*DISCOUNT2;
		else if (userAge>=30)
			price=price-price*2*DISCOUNT1;
		else if(userAge>=18)
		    price=price-price *2*DISCOUNT2;
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
