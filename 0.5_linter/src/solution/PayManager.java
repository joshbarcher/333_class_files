package solution;

import management.PayCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A small console app for calculating pay
 *
 * @author Josh Archer
 * @version 1.0
 */
public class PayManager
{
    private static final int HOURS_ADDED = 12;

    /**
     * Entry point for the application
     * @param args the command-line args (not used)
     */
    public static void main(String[] args)
    {
        String name;
        //run a second test
        try (Scanner console = new Scanner(System.in))
        {
            for (int i = 1; i <= 3; i++)
            {
                //enter a name
                System.out.print("Enter a name: ");
                name = console.nextLine();

                //get a pay rate and print the pay
                System.out.print("Enter a payrate: ");
                double payRate = console.nextDouble();
                console.nextLine();

                //enter an amount of hours
                System.out.print("Enter # of hours: ");
                int hours = console.nextInt();
                console.nextLine();

                //pad hours by 12
                hours += HOURS_ADDED;

                management.PayCalculator calculator = new PayCalculator(payRate, name);
                double pay = calculator.calculatePay(false, hours);

                System.out.println("Pay: $" + pay);
                System.out.println();
            }
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Input mismatch");
        }
        catch (Exception ex)
        {
            System.out.println("Error!");
        }
    }
}
