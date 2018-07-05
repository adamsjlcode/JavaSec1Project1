/*Program Name:			Proj1.java
 *Programmer:			Justin Adams
 *Class:				CSCI-003
 *Lab:					Project1
 *Purpose: 				Ask The User For His/Her Name And The Billing Rate/hr And 
 *						The Number Of Billable Hours And Minutes. Display Results in 
 *						Different DecimalFormat. Plus Display A Letter That User 
 *						Wants In Displayed.					 
 *Due Date:				September 23, 2015
 */
import java.util.Scanner;		//User Input From Keyboard
import java.text.DecimalFormat;	//Display User Input In Different Formats

public class Proj1 
{
	public static void main(String[] args)
	{
		double dMinutesTotal;			//Combination Of All User Time
		double dMinutes;				//User Input First Entered Minutes
		double dRate;					//User Input For Daily Rate
		double dHours;					//User Input First Entered Hours 
		double dBilling;				//User Input Amount Of Hours
		double dBillingMin;				//User Input Amount Of Minutes
		final int MINUTE = 60;			//A Minute In Seconds
		String strName;					//User Input For A Name
		String strAssign;				//Programmer Info
		String strDueDate;				//Programmer Info
		Scanner kbinput = new Scanner(System.in);		//User Input From Keyboard	
		DecimalFormat comma1 = new DecimalFormat("#,##0");		//Comma W/O Decimal
		DecimalFormat money = new DecimalFormat("$#,##0.00");	//Currency		

		
		System.out.print("What is the assignment: ");
		strAssign = kbinput.nextLine();
		System.out.print("When is this due: ");
		strDueDate = kbinput.nextLine();
		theProgrammerInfo(strAssign, strDueDate);				//Programmer Info
		System.out.println("**************ATTORRNEY BILLING SERVICE*************");
		System.out.print("\nWhat is your billing rate an hour: ");
		dRate = kbinput.nextDouble();
		System.out.print("What is the number of billable houres and "
										+ "additional minutes:");
		dHours = kbinput.nextDouble();
		dMinutes = kbinput.nextInt();
		kbinput.nextLine();
		strName = numberUpperCaseLetter(kbinput);	
									//To Show/Change User Upper Case Letter																									
		System.out.print("\n\nBillable time in different units:");
		System.out.print("\n\tEntered Minutes: "
										+ comma1.format(dMinutes));	
		dMinutes = (((int)dMinutes + 4) / 5) * 5;		
									//Rounding Up To The Nearest Five
		System.out.print("  Adjusted minutes: " 
										+ comma1.format(dMinutes));
		dMinutesTotal = (dHours * MINUTE) + dMinutes;
									//Actual Accurate Hours With Minutes						
		timeMeasurement( dMinutesTotal,MINUTE,comma1);
									//Display User Input In Different Units Of Time
		System.out.printf("\n\n%s, you should bill your "+
							"client the following: ", strName );
		dBilling = dHours * dRate;	//Get Amount Owed From Hours
		dBillingMin = (dMinutes/MINUTE) * dRate;		
									//Get Amount Owed From Minutes
		System.out.print("\n\t   Rate: " + money.format(dRate) + " /hour");
		System.out.print("\n\t  Hours: " + comma1.format(dHours) +  "\t"
										 + money.format(dBilling)+"\n");
		System.out.print("\tMinutes: "   + comma1.format(dMinutes) + "\t"
										 + money.format(dBillingMin)+"\n");
		dBilling += dBillingMin;	//Combine Amounts For Total
		System.out.print("\t  Total: "   + money.format(dBilling));
	}//End Main (String[])
			
	public static void theProgrammerInfo(String Assign,String Date)
	/** 
	 * Method Name: theProgrammerInfo
	 * Method Purpose: Display Information About Programmer 
	 * 
	 * Date:09/23/2015
	 * 
	 * Notes: Ask User For The Of Assignment And Due Date
	 * Display With The Assignment And Due Date
	 * 
	 * 	@param Scanner kbinput User Input From Keyboard
	 */
	{
		System.out.print("\nProgram Name:\tProj1.java");
		System.out.print("\n  Programmer:\tJustin Adams");		
		System.out.print("\n       Class:\tCSCI 1250-003");
		System.out.print("\n         Lab:\t" + Assign);
		System.out.print("\n    Due Date:\t" + Date + "\n\n");	
	}//End theProgrammerInfo(String,String)
	public static String numberUpperCaseLetter(Scanner kbinput)
	/**
	 * Method Name: numberUpperCaseLetter
	 * Method Purpose:Method To Ask User There Name And Display
	 * User Input For A Character
	 * 
	 * Date:09/23/2015
	 * 
	 * Notes: 
	 * 
	 * 
	 * 	@param Scanner kbinput User Input From Keyboard
	 */
	{
		byte bLetter;					//User Input For Letter Place
		char cLetter;					//User Display Letter
		String strName;					//User Input For Name
		String strLetter;				//Hold User's Letter	
		String strLetterUp;				//Hold User's Upper Case Letter
		
		System.out.print("What is your name? ");
		strName = kbinput.nextLine();
		System.out.print("Which letter do you want displayed? : ");
		bLetter = kbinput.nextByte();
		cLetter = strName.charAt(bLetter);	//User Input For Letter Place
		strLetter = String.valueOf(cLetter);//Changing The Value To String
		strLetterUp = strLetter.toUpperCase();	
											//Charging The Character To Upper Case
		System.out.print("Letter # " + bLetter + " "  
						 +  "is " + strLetterUp );
		return strName;
	}//End numberUpperCaseLetter(Scanner)
	
	public static void timeMeasurement(double total,final int MINUTE, 
										DecimalFormat comma1)
	/** 
	 * Method Name: timeMeasurement
	 * Method Purpose: Display User Input In Different Units Of Time
	 * 
	 * Date:09/23/2015
	 * 
	 * 
	 * 
	 * 	@param total - Combination Of All User Time
	 *  @param MINUTE - A Minute In Seconds
	 *  @param comma1 - Comma W/O Decimal
	 *  
	 */
	{
		final int DAY = 24;				//One Day In Hours
		final int WEEK = 7;				//One Week In Days
		final double MONTH = 30.42;		//One Month In Days
		final int YEAR = 356;			//One Year In Days
		DecimalFormat months = new DecimalFormat(".0###");		//Rounding 4 Place
		DecimalFormat years = new DecimalFormat(".0####");		//Rounding 5 Place
		DecimalFormat percent = new DecimalFormat("0.0#%");		//Percent	
		DecimalFormat comma2Decimal = new DecimalFormat("#,###.00");//With Decimal
		System.out.print("\n\t  Total: "  + comma1.format(total) +
							" Minutes");								
		total *= MINUTE;				//Amount Of Time In Seconds																			
		System.out.println("\n\tSeconds: " + comma1.format(total));
		total = (total / MINUTE)/MINUTE;//Change Time Back To Hours 
		System.out.println("\t  Hours: " +   comma2Decimal.format(total));
		total /= DAY;					//Amount Of Time In Day
		System.out.println("\t   Days: " +   comma2Decimal.format(total));
		total /= WEEK;					//Amount Of Time In Week
		System.out.println("\t  Weeks: " +   comma2Decimal.format(total));
		total *= WEEK;					//Change Weeks Amount Back To Hours
		total /= MONTH;					//Amount Of Time In Month
		System.out.println("\t Months: " +   months.format(total));
		total *= MONTH;					//Change Months Amount Back To Hours
		total /= YEAR;					//Amount Of Time In Year
		System.out.print("\t  Years: " +     years.format(total));
		System.out.print(" or " +            percent.format(total));
	}//End timeMeasurement(Double,Final Int,DecimalFormat)
	
}//End Project1

