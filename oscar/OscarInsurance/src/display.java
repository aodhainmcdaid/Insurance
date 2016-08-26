import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.*;


public class display {
	public static void main(String[] args) throws IOException {
		Scanner keyIn = new Scanner(System.in);
		GregorianCalendar gcal = new GregorianCalendar();
		int d3 = 0;	int m3 = 0;	int y3 = 0;
		boolean flag1;
		do{
			flag1= true;
			System.out.println("Enter Your Date Of Birth - dd/mm/yyyy");

			System.out.println("Enter Day" + "- dd - ");
			d3 = checkRange(1, 31);
			System.out.println("Enter month" +"- mm - ");
			m3 = checkRange(1, 12);
			System.out.println("Enter Year" +"- yyyy - ");
			y3 = checkRange(1000, 9999);
			if(validDate(d3,m3,y3)== false){
				System.out.println("Invalid Date.");
				flag1=false;
			}
		}while(flag1 == false);
		int yrsOld =ageDate(d3, m3, y3);
		System.out.println("\t\t   You Are "+yrsOld+" Years Old Today!");
	
		
		
		
	}
	public static int ageDate (int dayBirth, int monthBirth, int yearBirth){
		GregorianCalendar gcal = new GregorianCalendar();
		int day = gcal.get(Calendar.DATE);
		int month = gcal.get(Calendar.MONTH );
		int year = gcal.get(Calendar.YEAR);
		int age =0;
		age =(daysElapsed(yearBirth, monthBirth, dayBirth, year, month+1, day )/365);
		return age;
	}
	public static int daysElapsed(int year1, int month1, int day1, int year2,int month2, int day2){
		if(validDate(day1, month1, year1) == true && (validDate(day2, month2, year2) == true)){	///if both dates are valid
			GregorianCalendar gregstartDate = new GregorianCalendar(year2, month2, day2);	//Pass the date as parameter to Gregorian Calendar method
			GregorianCalendar gregendDate = new GregorianCalendar(year1, month1,day1);	//Pass the date as parameter to Gregorian Calendar method
			Date startDate = gregstartDate.getTime();	//returns the date as Date Object in milliseconds
			Date endDate = gregendDate.getTime();
			long startDMS = startDate.getTime();
			long endDMS = endDate.getTime();
			long elapsedMS = startDMS - endDMS;	//time between dates in milliseconds
			long elapsedDays = (elapsedMS / (24*60*60*1000));	//multiply  by 1000 to get seconds, by 60 to get minutes, by 60 to get hours and by 24 to get days
			return (int)elapsedDays;
		}
		else
			return 0;
	}
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
	public static int checkRange(int min, int max) throws IOException
	{
		int range =0;
		Scanner keyIn = new Scanner(System.in);
		range =keyIn.nextInt(); ;

		if(range < min || range > max)	//If range is incorrect..
		do
		{   
			System.out.println("\t\tInvalid! Please enter number "+min+" - "+max);
			System.out.println("\t\t\tEnter a value");
			range = keyIn.nextInt();
		}while(range < min || range > max);
		return range;

	}
	
	
	//This is the display class 

}
