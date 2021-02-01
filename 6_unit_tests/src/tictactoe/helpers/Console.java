package tictactoe.helpers;

import java.util.Scanner;

/**
 * Helper class for reading and writing to the Java console.
 * 
 * @author Josh Archer
 * @version 1.0
 */
public class Console
{
	private static Scanner console = new Scanner(System.in);
	
	/**
	 * Prints a message to the Java console.
	 * 
	 * @param message the message to be printed
	 */
	public static void print(String message)
	{
		System.out.println(message);
	}
	
	/**
	 * Retrieves a String value from the Java console.
	 * 
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return a String value
	 */
	public static String getString(String prompt)
	{
		System.out.print(prompt + ": ");
		return console.nextLine();
	}
	
	/**
	 * Retrieves an int value from the Java console.
	 * 
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return an int value
	 */
	public static int getInt(String prompt)
	{
		System.out.print(prompt + ": ");
		while (!console.hasNextInt())
		{
			System.out.print("Please enter a valid integer: ");
			
			//clear the scanner buffer
			console.nextLine();
		}
		
		int result = console.nextInt();
		
		//clear the scanner buffer
		console.nextLine();
		
		return result;
	}

	/**
	 * Retrieves a double value from the Java console.
	 * 
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return a double value
	 */
	public static double getDouble(String prompt)
	{
		System.out.print(prompt + ": ");
		while (!console.hasNextDouble())
		{
			System.out.print("Please enter a valid double: ");
			
			//clear the scanner buffer
			console.nextLine();
		}
		
		double result = console.nextDouble();
		
		//clear the scanner buffer
		console.nextLine();
		
		return result;
	}

	/**
	 * Retrieves a boolean value from the Java console.
	 * 
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return a boolean value
	 */
	public static boolean getBoolean(String prompt)
	{
		System.out.print(prompt + ": ");
		while (!console.hasNextBoolean())
		{
			System.out.print("Please enter true/false: ");
			
			//clear the scanner buffer
			console.nextLine();
		}
		
		boolean result = console.nextBoolean();
		
		//clear the scanner buffer
		console.nextLine();
		
		return result;
	}
}