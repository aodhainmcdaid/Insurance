package lyit.oscar.insurance;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;

/**
 * This class's only function is to start the app and call the run class.
 * @author Melissa, Daniela, Aodhain, and Fred
 */
public class PolicyDetails {

	private String type;
	private LocalDate start;
	private LocalDate end;
	private String payment;
	private int policyID;
	private double cost;
	
	/**
	 * Constructor for the Policy
	 * @param policyType	The policy type to be created
	 * @param policyStart	The start date of the policy
	 * @param policyEnd		The end date of the policy
	 * @param paymentType	The form of payment the user has chosen
	 */
	public PolicyDetails(String policyType, LocalDate policyStart, LocalDate policyEnd, String paymentType)
	{
		this.type=policyType;
		this.start=policyStart;
		this.end=policyEnd;
		this.payment=paymentType;
	}
	
	/**
	 * Sets the policy type to the given string
	 * @param PolicyIn	the type of the policy
	 */
	public void setPolicyType(String PolicyIn)
	{
		this.type=PolicyIn;
	}
	
	/**
	 * Gets the string value of the policy type	
	 * @return	The policy type in String format
	 */
	public String getPolicyType()
	{
		return type;
	}
	
	/**
	 * Gets the price of the policy object as a double
	 * @return	the price the current policy costs as a double
	 */
	public double getPolicyCost()
	{
		return cost;
	}
	
	/**
	 * Sets the price of the current policy
	 * @param costIn	The price of a the current policy
	 */
	public void setPolicyCost(double costIn)
	{
		cost = costIn;
	}
	
	/**
	 * This sets the date the policy will be valid from
	 * @param startIn	the date that the policy starts on 
	 */
	public void setPolicyStart(LocalDate startIn)
	{
		this.start=startIn;
	}
	
	/**
	 * This returns the date as a LocalDate 
	 * @return	the date that the policy is valid from
	 */
	public LocalDate getPolicyStart()
	{
		return start;
	}
	
	/**
	 * This method sets the policy end date
	 * @param endIn	The date that the policy if valid to
	 */
	public void setPolicyEnd(LocalDate endIn)
	{
		this.end=endIn;
	}
	
	/**
	 * This method returns the policy end date
	 * @return	the date that the policy is valid to
	 */
	public LocalDate getPolicyEnd()
	{
		return end;
	}
	
	/**
	 * This sets the payment type entered by the customer
	 * @param paymentIn	The string value entered for the payment
	 */
	public void setPaymentType(String paymentIn)
	{
		this.payment=paymentIn;
	}
	
	/**
	 * This method returns the payment type
	 * @return	the string value of the payment type
	 */
	public String getPaymentType()
	{
		return payment;
	}
	
	/**
	 * This method returns the policy ID as an int
	 * @return	the policy ID
	 */
	public int getPolicyID()
	{
		return policyID;
	}
	
	/**
	 * This method sets the policy ID
	 * @param policyIDIn	the unique policy ID
	 */
	public void setPolicyID(int policyIDIn)
	{
		policyID = policyIDIn;
	}
	
	/**
	 *  This method returns the policy information as a string.
	 *  @return	the full policy details as a String
	 */
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
