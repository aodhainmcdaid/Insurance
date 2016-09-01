package lyit.oscar.insurance;
//imports
import java.util.Random;

public class Pricing {
	//Variables
	private User currentUser;
	
	/**
	 * 
	 * @param aUser	this is the current user
	 */
	Pricing(User aUser){
		this.currentUser = aUser;
		generatePrice();
	}
	
	private void generatePrice(){
		//TODO Generate a price for the user, and then ask them if they want to purchase 
		
		//If the user accepts, generate policy number
		generatePolicyNum();
	}
	
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
