package lyit.oscar.insurance;
import java.util.ArrayList;

public class Lists {
	//Variables
	
	static ArrayList <User> allUsers = new ArrayList<>();
	User user;

	static public ArrayList<User> getUserList(Boolean priv){
		if(priv)
		{
			return allUsers;
		}
		else
		{
			return null;
		}
	}
	
	static User find(User aUser, ArrayList<User> userList)
	{ 
		for(User a : userList)  //for each user in list
		{
			if(a.equals(aUser))  //if I find it
		    	{
					return null; //return immediately if found 
		        }
		}
		return aUser;  //not found
	}
	
	static public void addUser(User aUser){
		//TODO: Design method to add user to list
		if(allUsers.isEmpty())
		{
			allUsers.add(aUser);
		}
		else
		{
			User newUser = find(aUser, allUsers); 
			allUsers.add(newUser);
		}
	}

}
