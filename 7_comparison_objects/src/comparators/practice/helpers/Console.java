package comparators.practice.helpers;

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
	 * Prints a message to the Java console with a new line at the end
	 * of the message.
	 *
	 * @param message the message to be printed
	 */
	public static void println(String message)
	{
		System.out.println(message);
	}

	/**
	 * Prints a message to the Java console.
	 *
	 * @param message the message to be printed
	 */
	public static void print(String message)
	{
		System.out.print(message);
	}

	/**
	 * Prompts the user and retrieves a String value from the Java console.
	 *
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return a String value
	 */
	public static String getString(String prompt)
	{
		System.out.println(prompt + ": ");
		return getString();
	}

	/**
	 * Retrieves a String value from the Java console.
	 *
	 * @return a String value
	 */
	public static String getString()
	{
		return console.nextLine();
	}

	/**
	 * Prompts the user and retrieves an int value from the Java console.
	 *
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return an int value
	 */
	public static int getInt(String prompt)
	{
		System.out.println(prompt + ": ");
		return getInt();
	}

	/**
	 * Retrieves an int value from the Java console.
	 *
	 * @return an int value
	 */
	public static int getInt()
	{
		while (!console.hasNextInt())
		{
			System.out.println("Please enter a valid integer: ");

			//clear the scanner buffer
			console.nextLine();
		}

		int result = console.nextInt();

		//clear the scanner buffer
		console.nextLine();

		return result;
	}

	/**
	 * Prompts the user and retrieves a double value from the Java console.
	 *
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return a double value
	 */
	public static double getDouble(String prompt)
	{
		System.out.println(prompt + ": ");
		return getDouble();
	}

	/**
	 * Retrieves a double value from the Java console.
	 *
	 * @return a double value
	 */
	public static double getDouble()
	{
		while (!console.hasNextDouble())
		{
			System.out.println("Please enter a valid double: ");

			//clear the scanner buffer
			console.nextLine();
		}

		double result = console.nextDouble();

		//clear the scanner buffer
		console.nextLine();

		return result;
	}

	/**
	 * Prompts the user and retrieves a boolean value from the Java console.
	 *
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return a boolean value
	 */
	public static boolean getBoolean(String prompt)
	{
		System.out.println(prompt + ": ");
		return getBoolean();
	}

	/**
	 * Retrieves a boolean value from the Java console.
	 *
	 * @return a boolean value
	 */
	public static boolean getBoolean()
	{
		while (!console.hasNextBoolean())
		{
			System.out.println("Please enter true/false: ");

			//clear the scanner buffer
			console.nextLine();
		}

		boolean result = console.nextBoolean();

		//clear the scanner buffer
		console.nextLine();

		return result;
	}

	/**
	 * Prompts the user and retrieves a char value from the Java console.
	 *
	 * @param prompt a prompt for the user to read before
	 * entering input
	 * @return a char value
	 */
	public static char getCharacter(String prompt)
	{
		System.out.println(prompt);
		return getCharacter();
	}

	/**
	 * Retrieves a char value from the Java console.
	 *
	 * @return a char value
	 */
	public static char getCharacter()
	{
		while (true)
		{
			String input = console.nextLine();

			if (input.length() == 1)
			{
				return input.charAt(0);
			}
			else
			{
				System.out.println("Please enter a single character: ");
			}
		}
	}
}
