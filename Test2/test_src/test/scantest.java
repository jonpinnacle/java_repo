/**
 * 
 */
package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 * @author jonathanmitchell
 *
 */

  
public class scantest {

	 public scantest(int days, int months, int years) {
		// TODO Auto-generated constructor stub
	}
	private static scantest calculateAge(final Date birthDate)
	   {
	      int years = 0;
	      int months = 0;
	      int days = 0;
	 
	      //create calendar object for birth day
	      Calendar birthDay = Calendar.getInstance();
	      birthDay.setTimeInMillis(birthDate.getTime());
	 
	      //create calendar object for current day
	      long currentTime = System.currentTimeMillis();
	      Calendar now = Calendar.getInstance();
	      now.setTimeInMillis(currentTime);
	 
	      //Get difference between years
	      years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	      int currMonth = now.get(Calendar.MONTH) + 1;
	      int birthMonth = birthDay.get(Calendar.MONTH) + 1;
	 
	      //Get difference between months
	      months = currMonth - birthMonth;
	 
	      //if month difference is in negative then reduce years by one 
	      //and calculate the number of months.
	      if (months < 0)
	      {
	         years--;
	         months = 12 - birthMonth + currMonth;
	         if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	            months--;
	      } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         years--;
	         months = 11;
	      }
	 
	      //Calculate the days
	      if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
	         days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
	      else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         int today = now.get(Calendar.DAY_OF_MONTH);
	         now.add(Calendar.MONTH, -1);
	         days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
	      } 
	      else
	      {
	         days = 0;
	         if (months == 12)
	         {
	            years++;
	            months = 0;
	         }
	      }
	      //Create new Age object 
	      return new scantest(days, months, years);
	   }
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// creates an object of Scanner
	    Scanner input = new Scanner(System.in);

	    System.out.print("Enter your First name: ");

	    // takes input from the keyboard
	    String First_name = input.nextLine();
	    System.out.print("Enter your Last name: ");
	    String Last_name = input.nextLine();
	    // prints the name
	    System.out.println("My name is " + First_name + " " + Last_name);
	    Date birthDate = sdf.parse("29/11/1981");     
	    scantest age = calculateAge(birthDate);

	    // closes the scanner
	    input.close();

	}

}
