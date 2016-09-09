package lyit.oscar.insurance;

import java.time.LocalDate;
import java.time.Period;

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
       public User2(String t, String first, String last, LocalDate bday,String pho, String gen, String em, String add, String pol){
    	   this.title = t;
    	   this.firstName = first;
    	   this.lastName = last;
    	   this.dob = bday;
    	   this.phone = pho;
    	   this.gender = gen;
    	   this.email = em;
    	   this.address = add;
    	   this.policyNo = pol;
       }



		public void setTitle(String titleIn){
			this.title = titleIn;
	
		}
		public String getTitle(){
			return title;
			//aaaa
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
			return phone;
		
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
       
}
