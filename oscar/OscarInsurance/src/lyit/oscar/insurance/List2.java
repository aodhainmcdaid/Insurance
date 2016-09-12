package lyit.oscar.insurance;

/**
 * @author Melissa and Daniela
 * 	Aodhain McDaid
 *  Fred Manu
 */
	
import java.util.ArrayList;

public class List2 {
	//Variables
	
	static ArrayList <User2> allUsers = new ArrayList<>();
	static ArrayList <policyDetails> allPolicy = new ArrayList<>();
	//User2 user;
	//private String policyNo;


	static public ArrayList<User2> getUserList(Boolean priv)
	{
		if(priv)
		{
			return allUsers;
		}
		else
		{
			return null;
		}
	}
	
	//return a customer in the list through policy number
	static User2 findPolicy(String policyNum, ArrayList<User2> userList)
	{ 	 
		for(User2 a : userList)  //for each user in list
		{	
			if(a.getPolicyNo().equalsIgnoreCase(policyNum))
			{				
					return a; //return immediately if found
			}
		}
		return null;  //not found.
			
	}
	
	//return customer in the list through customer object
	static User2 find(User2 aUser, ArrayList<User2> userList)
	{ 	 
		for(User2 a : userList)  //for each user in list
		{	
			if(a.equals(aUser))  //if I find it
			{					 
				return aUser; //return immediately if found
			}
		}
		return null;  //not found.
	}
	
	// Design method to add user to list
	static public User2 addUser(User2 aUser)
	{
		
		if(allUsers.isEmpty())
		{
			allUsers.add(aUser);
		}
		else
		{
			User2 newUser = find(aUser, allUsers); 
			if(newUser == null)
			{
				allUsers.add(newUser);
				return newUser;
			}
		}
		return aUser;
	}
	
	// Design method to add user to list
		static public policyDetails addPolicy(policyDetails policy)
		{
			
			if(allPolicy.isEmpty())
			{
				allPolicy.add(policy);
			}
			else
			{
				policyDetails newPolicy = findPolicyID(policy.getPolicyID(), allPolicy); 
				if(newPolicy == null)
				{
					allPolicy.add(newPolicy);
					return newPolicy;
				}
			}
			return policy;
		}
		static policyDetails findPolicyID(int policyNum, ArrayList<policyDetails> allPolicy)
		{ 	 
			for(policyDetails a : allPolicy)  //for each user in list
			{	
				if(a.getPolicyID() == policyNum)
				{				
						return a; //return immediately if found
				}
			}
			return null;  //not found.
				
		}
		
	
	//delete customer from list 
	static User2 deleteUser(String policyNum)
	{
		if(!allUsers.isEmpty())
		{
			User2 newUser = findPolicy(policyNum, allUsers);	
			if(newUser != null);
			{
				allUsers.remove(newUser);	
				return newUser;
			}			
		}
		return null;
	}
	
	//TODO:
	/*public void updateCustDetails(String policyNum)
	{
		if(!allUsers.isEmpty())
		{
			User2 newUser = findPolicy(policyNum, allUsers);
			return newUser;
				break;            
			}
		}
		else
		{
			return null;
		}
	}*/
	
	//Check if policy exists in the user list
	public static User2 viewPolicy(String policyNum)
	{
		if(!allUsers.isEmpty())
		{
			User2 newUser = findPolicy(policyNum, allUsers);
			if(newUser != null )
			{
				return newUser;
			}
		}
		return null;
	}
	
	//displays customer details
	public static void displayUser(User2 aUser)
	{
		System.out.println(aUser);
	}	
	public static policyDetails getPolicyDetails()
	{
		return allPolicy.get(allPolicy.size()-1);
	}
}

