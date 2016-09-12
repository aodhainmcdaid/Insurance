package lyit.oscar.insurance;


import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;




public class policyDetails {

	private String type;
	private LocalDate start;
	private LocalDate end;
	private String payment;
	private int policyID;
	private static int counter=5;
	
	
	
	public policyDetails(String policyType, LocalDate policyStart, LocalDate policyEnd, String paymentType)
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
	public LocalDate getEnd()
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
		policyID=counter;
		counter++;
		
	}
	
	
	
	
	
	
}
