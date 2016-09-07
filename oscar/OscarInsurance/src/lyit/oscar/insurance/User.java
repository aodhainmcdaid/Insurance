package lyit.oscar.insurance;

import java.time.LocalDate;
import java.time.Period;

public class User {
       //Variables 
       private String screenName;
       private String firstName;
       private String lastName;
       private LocalDate birthday;
       private Boolean adminPriv;
       private int policyNum;
       private int password;
       private int policyPrice;
       private int policyPay;
       private String gender;
       
       /**
        * This class contains important user information
        * 
        * @param sn		The user's chosen screen name
        * @param first	The user's first name
        * @param last	The user's last name
        * @param anAge	The user's age
        * @param pass	The user's chosen password
        * @param ad		The user's administration privilege - should always be false unless creating a new user from the Admin Class
        */
       public User(String sn, String first, String last, LocalDate bday, int pass, Boolean ad, String gender){
    	   this.screenName = sn;
    	   this.firstName = first;
    	   this.lastName = last;
    	   this.birthday = bday;
    	   this.adminPriv = false;
    	   this.policyNum = 0;
    	   this.password = pass;
    	   this.adminPriv = ad;
    	   this.gender = gender;
       }
       
       /**
        * Checks if the password is correct when the user attempts to log in to their account.
        * 
        * @param aPass	The password the user entered to access their account
        * @return		If the password the user supplied matches the password that they set
        */
       public boolean logIn(int aPass){
    	   return this.password == aPass;
       }
       
       /**
        * Sets the policy number of the user
        * 
        * @param num	The user's given policy number for their insurance
        */
       public void setPolicyNum(int num){
    	   this.policyNum = num;
       }
       
       /**
        * Allows the program to set the price of the policy, and store it with the user.
        * 
        * @param num	The price per payment term of the policy
        * @param months	The number of months between payments. i.e. paying once a year would be 12, paying once a month would be 1
        */
       public void setPolicyPrice(int num, int months){
    	   this.policyPrice = num;
    	   this.policyPay = months;
       }
       
       /**
        * 
        * @return
        */
       public int getPolicyPrice(){
    	   return this.policyPrice;
       }
       
       /**
        * 
        * @return
        */
       public int getPolicyPay(){
    	   return this.policyPay;
       }
       
       /**
        * 
        * @return
        */
       public String getGender(){
    	   return this.gender;
       }
       
       /**
        * Gets the user's screen name
        * 
        * @return	The user's chosen screen name
        */
       public String getScreenName(){
    	   return this.screenName;
       }
       
       /**
        * Gets the user's full name
        * 
        * @return	The user's first and last name separated by a space
        */
       public String getFullName(){
    	   return this.firstName + " " + this.lastName;
       }
       
       /**
        * Gets the user's first name
        * 
        * @return	The user's first name
        */
       public String getFirstName(){
    	   return this.firstName;
       }
       
       /**
        * Gets the user's last name
        * 
        * @return	The user's last name
        */
       public String getLastName(){
    	   return this.lastName;
       }
       
       /**
        * Gets the user's age
        * 
        * @return 	The user's age
        */
       public int getAge(){
    	   LocalDate today = LocalDate.now();
    	   int age = Period.between(birthday, today).getYears();
    	   return age;
       }
       
       /**
        * Gets the user's administrative privilege
        * 
        * @return	The user's administrative privilege
        */
       public Boolean getAdmin(){
    	   return this.adminPriv;
       }
       
       /**
        * Gets the user's  policy number
        * 
        * @return	The User's individual policy number
        */
       public int getPolicyNum(){
    	   return this.policyNum;
       }

}
