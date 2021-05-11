/**
 * 
 */
package test;
import java.util.Scanner;
/**
 * @author jonathanmitchell
 *
 */
public class scantest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creates an object of Scanner
	    Scanner input = new Scanner(System.in);

	    System.out.print("Enter your First name: ");

	    // takes input from the keyboard
	    String First_name = input.nextLine();
	    System.out.print("Enter your Last name: ");
	    String Last_name = input.nextLine();
	    // prints the name
	    System.out.println("My name is " + First_name + " " + Last_name);

	    // closes the scanner
	    input.close();

	}

}
