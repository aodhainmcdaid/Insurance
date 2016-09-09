package lyit.oscar.insurance;
//imports
import java.util.Random;

/**
 * @author Melissa Melaugh
 */
public class Pricing {
	double  price= 0;
	int discaunt=0;
	
	private User currentUser;
	
	/**
	 * The constructor for the pricing class
	 * @param aUser	this is the current user
	 */
	Pricing(User aUser){
		this.currentUser = aUser;
		generatePrice();
	}
	
	/**
	 * This method looks at the current user and generates a price based on their data.
	 * If they wish to purchase, it generates a policy number and updates the User's information.
	 */
	private void generatePrice()
	
	{ 
		
		//TODO Generate a price for the user, and then ask them if they want to purchase 
		//TODO: When purchasing, ask how often they would like to pay
		
		//If the user accepts, generate policy number
		generatePolicyNum();
		//Update Pricing on the User's profile
	}
	
	/**
	 * This method generates a unique policy number for the user between 100000000 and 999999999. 
	 * It updates the user's profile with their unique policy number.
	 */
	private void generatePolicyNum(){
		int polNum = 0;
		
		//Generates the policy number
		while(true){
			Random rnd = new Random();
			polNum = rnd.nextInt(899999999) + 100000000; //makes sure the policy number is between 100000000 and 999999999
			User[] userList = Lists.getUserList(true);
			Boolean generated = true;
			
			//Check to make sure that policy numbers are not duplicated
			for(User user:userList){
				int toCheck = user.getPolicyNum();
				if(toCheck == polNum){
					generated = false; //If it is a duplicate, it's not properly generated
				}
			}
			
			if(generated){
				break;
			}
		}
		currentUser.setPolicyNum(polNum);
	}
	
}
