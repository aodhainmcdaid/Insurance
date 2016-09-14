package lyit.oscar.insurance;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;

/**
 * This class constructs a user.
 * @author Melissa, Daniela, Aodhain, and Fred
 */
public class User {
	//Variables 
	private String title;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String phone;
	private String gender;
	private String email;
	private String address;
	private String policyNo;
	private int personID;
	private double insuranceCost;
	
	/**
	 * Main constructor for the Users Class
	 * @param t		The user's preferred title
	 * @param first	The user's first time
	 * @param last	The user's last name
	 * @param bday	The user's birthday
	 * @param pho	The user's phone number
	 * @param gen	The user's gender
	 * @param em	The user's email
	 * @param add	The user's address
	 */
	public User( String t, String first, String last, LocalDate bday, String pho, String gen, String em, String add){
		this.title = t;
		this.firstName = first;
		this.lastName = last;
		this.dob = bday;
		this.phone = pho;
		this.gender = gen;
		this.email = em;
		this.address = add;
	}

	/**
	 * Constructor featuring only the first and last name of the user
	 * @param first	The user's first name
	 * @param last	The user's last name
	 */
	public User(String first, String last)
	{
		this.firstName = first;
		this.lastName = last;
	}
	
	/**
	 * Empty Constructor
	 */
	public User(){}

	public void setTitle(String titleIn){
		this.title = titleIn;	
	}
	
	/**
	 * Gets the user's preferred title
	 * @return	the user's title as a string
	 */
	public String getTitle(){
		return title;			
	}
	
	/**
	 * Sets the user's first name
	 * @param fnameIn	The user's first name
	 */
	public void setFname(String fnameIn){
		this.firstName = fnameIn;	
	}
	
	/**
	 * Gets the user's first name
	 * @return	The user's first name as a string
	 */
	public String getFname(){
		return firstName;	
	}
	
	/**
	 * Sets the user's last name
	 * @param lnameIn	The user's last name
	 */
	public void setlname(String lnameIn){
		this.lastName = lnameIn;	
	}
	
	/**
	 * Gets the user's last name
	 * @return	The user's last name
	 */
	public String getlname(){
		return lastName;	
	}

	/**
	 * Get's the user's date of birth
	 * @return	The user's date of birth
	 */
	public LocalDate getDOB(){
		return dob;
	}
	
	/**
	 * Sets the user's date of birth
	 * @param dobIn	The user's date of birth
	 */
	public void setDOB(LocalDate dobIn){
		this.dob = dobIn;
	}
	
	/**
	 * Sets the user's phone number
	 * @param phoneIn	the user's phone number
	 */
	public void setPhone(String phoneIn){
		this.phone = phoneIn;
	}
	
	/**
	 * Gets the user's phone number
	 * @return	The user's phone number
	 */
	public String getPhone(){
		return phone;
	}
	
	/**
	 * Sets the user's gender
	 * @param genderIn	the user's gender as a string
	 */
	public void setGender(String genderIn){
		this.gender = genderIn;
	}
	
	/**
	 * Gets the user's gender
	 * @return	the user's gender
	 */
	public String getGender(){
		return gender;
	}
	
	/**
	 * Sets the user's email
	 * @param emailIn	The user's email
	 */
	public void setEmail(String emailIn){
		this.email = emailIn;
	}
	
	/**
	 * Gets the user's email
	 * @return	The user's email
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * Sets the user's address
	 * @param addressIn	the user's address
	 */
	public void setAddress(String addressIn){
		this.address = addressIn;
	}
	
	/**
	 * Gets the user's address
	 * @return	the user's address
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * Sets the policy number
	 * @param policyNoIN	the policy number as a string value
	 */
	public void setPolicyNo(String policyNoIN){
		this.policyNo = policyNoIN;
	}
	
	/**
	 * Gets the user's policy number
	 * @return	The user's policy number
	 */
	public String getPolicyNo(){
		return policyNo;
	}
	
	/**
	 * Checks if this user is the same as another user
	 * @param anotherUser	a user to compare
	 * @return				true if the user is a duplicate, false if it is not
	 */
	public boolean equals(User anotherUser)
	{
		return( policyNo == anotherUser.policyNo
				&&  firstName == anotherUser.firstName
				&&  lastName == anotherUser.lastName);
	}
	
	/**
	 * Gets the age of the user based on their birthday and today's date
	 * @return	the users numeric age
	 */
	public int getAge(){
  	   LocalDate today = LocalDate.now();
  	   int age = Period.between(dob, today).getYears();
  	   return age;
    }
	
	/**
	 * This method creates a string of all of the user's information
	 * @return the created string based on their information
	 */
	public String toString()
	{
		String str = "";    

		str = str + "ID: " +(getPersonID());
		str = str + "\ntitle: " +(getTitle().isEmpty()?"":getTitle());
		str = str + "\nfirst name: "+(getFname().isEmpty()?"":getFname());
		str = str + "\nlast name: "+(getlname().isEmpty()?"":getlname());
		str = str + "\nAddress: "+(getAddress().isEmpty()?"":getAddress());
		str = str + "\nphone number: "+(getPhone().isEmpty()?"":getPhone());
		str = str + "\ndate of birth: "+(getDOB() != null?getDOB():"");
		str = str + "\ngender: "+(getGender().isEmpty()?"":getGender());
		str = str + "\nemail: "+(getEmail().isEmpty()?"":getEmail());
		str = str + "\npolicy number: "+(getPolicyNo().isEmpty()?"":getPolicyNo());
		str = str + "\ncost: "+(getInsuranceCost() < 0?"":getInsuranceCost());

		return str;
	}
	
	/**
	 * Sets the person id
	 * @param personIDIn	the numeric ID number of the user
	 */
	public void setPersonID(int personIDIn)
	{
		personID = personIDIn;
	}
	
	/**
	 * Gets the person ID
	 * @return	the numeric ID of the user
	 */
	public int getPersonID()
	{
		return personID;
	}

	/**
	 * Gets the cost of the insurance
	 * @return	the cost of the user's insurance
	 */
	public double getInsuranceCost()
	{
		return insuranceCost;
	}

	/**
	 * Sets the cost of the user's insurance
	 * @param insuranceCostIn	the cost of the user's insurance
	 */
	public void setInsuranceCost(double insuranceCostIn) 
	{
		this.insuranceCost = insuranceCostIn;
	}

}
