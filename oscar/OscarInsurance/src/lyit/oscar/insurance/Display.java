package lyit.oscar.insurance;
//Imports
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;


public class Display {
	//Variables
	GregorianCalendar gcal;
	
	/**
	 * TODO: Finish refactoring, add comments
	 * TODO: create an HTML page so that it's not a bunch of "Please input" statements.
	 */
	Display(){
		this.gcal = new GregorianCalendar();
		int d3 = 0;	
		int m3 = 0;	
		int y3 = 0;
		boolean flag1;
		
		do{
			flag1= true;
			System.out.println("You will be prompted to enter the components of your date of birth.");
			
			//This checks to make sure that all of the information entered works.
			try {
				String question = "Enter the day: \n";
				d3 = checkRange(question, 1, 31);
				question = "Enter the month: \n";
				m3 = checkRange(question, 1, 12);
				question = "Enter the full year: \n";
				y3 = checkRange(question, 1900, 9999);
			} catch (IOException e) {
				System.out.print("");
			}
			
			//Makes sure the date is correct
			if(validDate(d3,m3,y3)== false){
				System.out.println("Invalid Date.");
				flag1=false;
			}
		}while(flag1 == false);
		
		int yrsOld =generateYearsOld(d3, m3, y3);
		System.out.println("Your age is " + yrsOld + ".");
	}
	
	/**
	 * 
	 * @param dayBirth
	 * @param monthBirth
	 * @param yearBirth
	 * @return
	 */
	public int generateYearsOld (int dayBirth, int monthBirth, int yearBirth){
		int day = gcal.get(Calendar.DATE);
		int month = gcal.get(Calendar.MONTH);
		int year = gcal.get(Calendar.YEAR);
		int yearsOld = 0;
		
		float age = daysElapsed(yearBirth, monthBirth, dayBirth, year, month, day ) / 365;
		
		yearsOld = (int)(age);
		
		if(age < yearsOld){
			yearsOld--;
		}
		return yearsOld;
	}
	
	/**
	 * 
	 * @param year1
	 * @param month1
	 * @param day1
	 * @param year2
	 * @param month2
	 * @param day2
	 * @return
	 */
	public static int daysElapsed(int year1, int month1, int day1, int year2,int month2, int day2){
		//Create the dates
		GregorianCalendar gregstartDate = new GregorianCalendar(year2, month2, day2);
		GregorianCalendar gregendDate = new GregorianCalendar(year1, month1,day1);
		
		Date startDate = gregstartDate.getTime();	//returns the date as Date Object in milliseconds
		Date endDate = gregendDate.getTime();
		long elapsedMS = startDate.getTime() - endDate.getTime();	//time between dates in milliseconds
		long elapsedDays = (elapsedMS / (24*60*60*1000));	//multiply  by 1000 to get seconds, by 60 to get minutes, by 60 to get hours and by 24 to get days
		return (int)elapsedDays;
	}
	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static boolean validDate(int day, int month, int year){
		if((year > 1000 && year < 9999) && (month <= 12 && month > 0) &&(day > 0 && day <= 31))
			if(leapYear(year)== true && month == 2 && day <= 29)	//if its a leapyear and month is february
				return true;
			else if((month == 4 || month == 6 || month == 9 || month == 11)&& day <= 30)	//if its a month with 30 days
				return true;
			else if(month == 2 && day <= 28)	//if its not a leapyear and month is february
				return true;
			else if((month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month ==  10 || month == 12) && day <= 31)//if its a month with 31 days
				return true;
			else
				return false;
		else
			return false;
	}
	
	/**
	 * 
	 * @param year
	 * @return
	 */
	public static boolean leapYear(int year){
		if (year % 4 == 0)
		    if (year % 100 == 0)
		    	if (year % 400 == 0)
		            return true;
		        else
		            return false;
	    	else
		       return true;
		else
		    return false;
	}
	
	/**
	 * 
	 * @param str
	 * @param min
	 * @param max
	 * @return
	 * @throws IOException
	 */
	public static int checkRange(String str, int min, int max) throws IOException
	{
		int range =0;
		Scanner keyIn = new Scanner(System.in);
		range = keyIn.nextInt(); ;

		if(range < min || range > max)	//If range is incorrect..
		do
		{   
			System.out.println("\t\tInvalid! Please enter number between " + min + " and " + max);
			System.out.println("\t\t\tEnter a value");
			range = keyIn.nextInt();
		}while(range < min || range > max);
		
		keyIn.close();
		return range;
	}
}
