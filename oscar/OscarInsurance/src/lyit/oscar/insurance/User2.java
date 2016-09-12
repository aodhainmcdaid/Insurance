/**
 * @author Melissa and Daniela
 * 	Aodhain McDaid
 *  Fred Manu
 */

package lyit.oscar.insurance;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;

public class User2 {
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
	private int policyType;
	private int personID;
	private static int counter=0;


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
	public User2(String t, String first, String last, LocalDate bday,String pho, String gen, String em, String add, int pType){
		this.title = t;
		this.firstName = first;
		this.lastName = last;
		this.dob = bday;
		this.phone = pho;
		this.gender = gen;
		this.email = em;
		this.address = add;
		this.policyType = pType;
	}

	public User2(String first, String last)
	{
		this.firstName = first;
		this.lastName = last;
	}
	//default constructor
	public User2(){}

	public void setTitle(String titleIn){
		this.title = titleIn;	
	}
	public String getTitle(){
		return title;			
	}
	public void setFname(String fnameIn){
		this.title = fnameIn;	
	}
	public String getFname(){
		return firstName;	
	}
	public void setlname(String lnameIn){
		this.title = lnameIn;	
	}
	public String getlname(){
		return lastName;	
	}
	public void DOB(LocalDate DOBIn){
		this.dob = DOBIn;	
	}
	public LocalDate getDOB(){
		return dob;
	}
	public void setDOB(LocalDate dobIn){
		this.dob = dobIn;

	}
	public void setPhone(String phoneIn){
		this.phone = phoneIn;

	}
	public String getPhone(){
		return phone;

	}
	public void setGender(String genderIn){
		this.gender = genderIn;

	}
	public String getGender(){
		return gender;

	}
	public void setEmail(String emailIn){
		this.email = emailIn;

	}
	public String getEmail(){
		return email;

	}
	public void setAddress(String addressIn){
		this.address = addressIn;

	}
	public String getAddress(){
		return address;

	}
	public void setPolicyNo(String policyNoIN){
		this.policyNo = policyNoIN;

	}
	public String getPolicyNo(){
		return policyNo;

	}

	public int getPolicyType() {
		return policyType;
	}
	public void setPolicyType(int policyType) {
		this.policyType = policyType;
	}

	public boolean equals(User2 anotherUser)
	{
		return( policyNo == anotherUser.policyNo
				&&  firstName == anotherUser.firstName
				&&  lastName == anotherUser.lastName);
	}
	 public int getAge(){
  	   LocalDate today = LocalDate.now();
  	   int age = Period.between(dob, today).getYears();
  	   return age;
     }
	public String toString()
	{
		String str = "";    

		str = str + "\ntitle: " +(getTitle().isEmpty()?"":getTitle());
		str = str + "\nfirst name: "+(getFname().isEmpty()?"":getFname());
		str = str + "\nlast name: "+(getlname().isEmpty()?"":getlname());
		str = str + "\nAddress: "+(getAddress().isEmpty()?"":getAddress());
		str = str + "\nphone number: "+(getPhone().isEmpty()?"":getPhone());
		str = str + "\ndate of birth: "+(getDOB() != null?getDOB():"");
		str = str + "\ngender: "+(getGender().isEmpty()?"":getGender());
		str = str + "\nemail: "+(getEmail().isEmpty()?"":getEmail());
		str = str + "\npolicy type: "+(getPolicyType() > 0? getPolicyType():"");
		str = str + "\npolicy number: "+(getPolicyNo().isEmpty()?"":getPolicyNo());

		return str;
	}
	public void setPersonID()
	{
		personID=counter;
		counter++;
	}
}
