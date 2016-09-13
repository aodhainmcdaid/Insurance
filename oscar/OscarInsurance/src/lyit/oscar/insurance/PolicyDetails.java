/**
 * @author Melissa and Daniela

 * 	Aodhain McDaid aaaa
 *  Fred Manu
 */

package lyit.oscar.insurance;


import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;




public class PolicyDetails {

	private String type;
	private LocalDate start;
	private LocalDate end;
	private String payment;
	private int policyID;
	private double cost;
	private static int counter=5;
	
	
	
	public PolicyDetails(String policyType, LocalDate policyStart, LocalDate policyEnd, String paymentType)
	{
		this.type=policyType;
		this.start=policyStart;
		this.end=policyEnd;
		this.payment=paymentType;
			
	}
	
	public void setPolicyType(String PolicyIn)
	{
		this.type=PolicyIn;
		
	}
	
	public String getPolicyType()
	{
		return type;
		
		
	}
	public double getPolicyCost()
	{
		return cost;
	}
	public void setPolicyCost(int costIn)
	{
		cost = costIn;
	}
	
	public void setPolicyStart(LocalDate startIn)
	{
		
		this.start=startIn;
		
	}
	public LocalDate getPolicyStart()
	{
		return start;
		
		
	}
	public void setPolicyEnd(LocalDate endIn)
	{
		this.end=endIn;
		
		
	}
	public LocalDate getPolicyEnd()
	{
		return end;
		
	}
	public void setPaymentType(String paymentIn)
	{
		this.payment=paymentIn;
		
	}
	public String getPaymentType()
	{
		return payment;
		
	}
	public int getPolicyID()
	{
		return policyID;
		
		
	}
	public void generatePolicyID()
	{
		policyID = counter;
		counter++;
		
	}
   public String toString()
   {
      String str = "";
      str = str + getPolicyID()+ "\n";
      str = str + getPolicyType()+"\n";
      str = str + getPolicyStart()+"\n";
	   str = str + getPolicyEnd()+"\n";
	   str = str + getPaymentType();
      
      return str;
   }	
}
