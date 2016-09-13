package lyit.oscar.insurance;

/**
 * @author Melissa and Daniela
 * 	Aodhain McDaid
 *  Fred Manu
 */
	
import java.util.ArrayList;

public class List {
	//Variables
	
	static ArrayList <User> allUsers = new ArrayList<>();
	static ArrayList <PolicyDetails> allPolicy = new ArrayList<>();
	//User2 user;
	//private String policyNo;


	static public ArrayList<User> getUserList(Boolean priv)
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
	
		
	// Design method to add user to list
	static public User addUser(User aUser)
	{
		
		if(allUsers.isEmpty())
		{
			allUsers.add(aUser);
		}
		else
		{
			User newUser = find(aUser, allUsers); 
			if(newUser == null)
			{
				allUsers.add(newUser);
				return newUser;
			}
		}
		return aUser;
	}
   
   //delete customer from list 
	static User deleteUser(String policyNum)
	{
		if(!allUsers.isEmpty())
		{
			User newUser = findPolicy(policyNum, allUsers);	
			if(newUser != null);
			{
				allUsers.remove(newUser);	
				return newUser;
			}			
		}
		return null;
	}

   
   // Design method to add user to list
		static public PolicyDetails addPolicy(PolicyDetails policy)
		{
			
			if(allPolicy.isEmpty())
			{
				allPolicy.add(policy);
			}
			else
			{
				PolicyDetails newPolicy = findPolicyID(policy.getPolicyID(), allPolicy); 
				if(newPolicy == null)
				{
					allPolicy.add(newPolicy);
					return newPolicy;
				}
			}
			return policy;
		}

	//Check if policy exists in the user list
	public static User viewPolicy(String policyNum)
	{
		if(!allUsers.isEmpty())
		{
			User newUser = findPolicy(policyNum, allUsers);
			if(newUser != null )
			{
				return newUser;
			}
		}
		return null;
	}

   //return a customer in the list through policy number
	static User findPolicy(String policyNum, ArrayList<User> userList)
	{ 	 
		for(User a : userList)  //for each user in list
		{	
			//if(a.getPolicyNo().equalsIgnoreCase(policyNum))
         if(a.getPolicyNo().equalsIgnoreCase(policyNum))
			{				
					return a; //return immediately if found
			}
		}
		return null;  //not found.
			
	}
	
	//return customer in the list through customer object
	static User find(User aUser, ArrayList<User> userList)
	{ 	 
		for(User a : userList)  //for each user in list
		{	
			if(a.equals(aUser))  //if I find it
			{					 
				return aUser; //return immediately if found
			}
		}
		return null;  //not found.
	}
   
   static PolicyDetails findPolicyID(int policyNum, ArrayList<PolicyDetails> policyList)
		{ 	 
			for(PolicyDetails a : policyList)  //for each user in list
			{	
				if(a.getPolicyID() == policyNum)
				{				
						return a; //return immediately if found
				}
			}
			return null;  //not found.				
		}


	   // static policyDetails findPolicyID(int policyNum, ArrayList<policyDetails> allPolicy)
// 		{ 	 
// 			for(policyDetails a : allPolicy)  //for each user in list
// 			{	
// 				if(a.getPolicyID() == policyNum)
// 				{				
// 						return a; //return immediately if found
// 				}
// 			}
// 			return null;  //not found.
// 				
// 		}
		
	
		
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
	
		
	//displays customer details
	public static void displayUser(User aUser)
	{
		System.out.println(aUser);
	}	
	public static PolicyDetails getPolicyDetails()
	{
		return allPolicy.get(allPolicy.size()-1);
		
	}

}

