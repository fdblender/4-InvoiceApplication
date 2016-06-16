/* InvoiceApplication.java
 * Author: Frances Blendermann * 
 * Create an application that allows the user 
 * to enter a tax rate followed by any number of prices. 
 * When the user enters a price of 0.0, 
 * the application should print out the list of prices entered 
 * followed by the subtotal, tax and grand total   
 * 6/16/16 - added exception handling (input error)
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class InvoiceApplication {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Double taxRate, price;
		Double subtotal = 0.0;
		Double grandtotal = 0.0;
		Double tax = 0.0;
		double myPrices[] = new double[100];
		int index = 1; // index to myPrices array
		boolean getMore = true;

		try {
			// read in tax rate
			System.out.println("Enter tax rate: ");
			taxRate = keyboard.nextDouble();

			// get prices
			while (getMore) {
				System.out.print("Price # " + index + " : ");
				price = keyboard.nextDouble();
				myPrices[index] = price;

				if (Double.compare(price, (double) 0.0) == 0) {
					getMore = false;
				} else {
					index++;
				}
			}
		
			// print prices
			System.out.println("\n---------------------------------\n");
			System.out.println("Receipt");
			for (int i = 1; i < index; i++) {
				System.out.println(String.format("%.02f", myPrices[i]));
				subtotal = subtotal + myPrices[i];
			}

			// calculate and print subtotal, tax and grandtotal
			tax = subtotal * taxRate;
			grandtotal = subtotal + tax;
			System.out.println(String.format("%.02f", subtotal) + " Subtotal");
			System.out.println(String.format("%.02f", tax) + "  Tax");
			System.out.println(String.format("%.02f", grandtotal) + " Grand Total");			
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Input Mismatch Exception");
		}catch (Exception e) {
			System.out.println("Error: General Exception");
		} 		
	}
}