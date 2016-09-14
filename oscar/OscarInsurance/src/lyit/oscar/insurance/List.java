package lyit.oscar.insurance;

import java.util.ArrayList;

/**
 * This class is used to handle all of the lists needed by the program.
 * @author Melissa, Daniela, Aodhain, and Fred
 */
public class List {
	//Variables
	static ArrayList <User> allUsers = new ArrayList<>();
	static ArrayList <PolicyDetails> allPolicy = new ArrayList<>();

	/**
	 * This method returns the user array list if the requester has the correct privilege
	 * @param priv	true if allowed to access the list, false if not
	 * @return		either a blank list or a filled list depending on the privilege
	 */
	static public ArrayList<User> getUserList(Boolean priv){
		if(priv){
			return allUsers;
		}else{
			return null;
		}
	}
	
	/**
	 * This method adds a user to the list
	 * @param aUser	the user to be added
	 * @return		the user that has been added
	 */
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
   
   	/**
   	 * Deletes a user from the list
   	 * @param policyNum	The policy number of the user to be deleted
   	 * @return			The user that is deleted
   	 */
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
   
 	/**
 	 * Adds a policy to the policy list
 	 * @param policy	the policy to be added
 	 * @return			the added policy
 	 */
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

	/**
	 * Gets the user details based on the policy number entered
	 * @param policyNum	The policy number to be viewed
	 * @return			The user who owns the policy
	 */
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

	/**
	 * Finds the user from the policy number
	 * @param policyNum	The number to search
	 * @param userList	The list of users
	 * @return			The user that belongs to the policy number
	 */
	static User findPolicy(String policyNum, ArrayList<User> userList)
	{ 	 
		for(User a : userList)  //for each user in list
		{	
         if(a.getPolicyNo().equalsIgnoreCase(policyNum))
			{				
				return a; //return immediately if found
			}
		}
		return null;  //not found.
			
	}
	
	/**
	 * Finds the user object in the User list
	 * @param aUser		the user to be found
	 * @param userList	the list to look through
	 * @return			null if not found, the user if they are found.
	 */
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
   
	/**
	 * 
	 * @param policyNum
	 * @param policyList
	 * @return
	 */
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
		
	/**
	 * Displays the user's details
	 * @param aUser	The user's details to be displayed
	 */
	public static void displayUser(User aUser)
	{
		System.out.println(aUser);
	}	
	
	/**
	 * 
	 * @return
	 */
	public static PolicyDetails getPolicyDetails()
	{
		return allPolicy.get(allPolicy.size()-1);
	}
}

