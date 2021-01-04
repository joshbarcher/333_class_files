package management;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class PayManager
{
    private static String name;

    public static void main(String[] args)
    {
        //run a second test
        try (Scanner console = new Scanner(System.in))
        {
            //enter a name
            System.out.print("Enter a name: ");
            name = console.nextLine();

            //get a pay rate and print the pay
            System.out.print("Enter a payrate: ");
            double pay_rate = console.nextDouble();
            console.nextLine();

            //enter an amount of hours
            System.out.print("Enter # of hours: ");
            int hours = console.nextInt();
            console.nextLine();

            //pad hours by 12
            hours += 12;

            PayCalculator calculator = new PayCalculator(pay_rate, name);
            double pay = calculator.calculatePay(false, hours);

            System.out.println("Pay: $" + pay);
            System.out.println();

            //enter a name
            System.out.print("Enter a name: ");
            name = console.nextLine();

            //get a pay rate and print the pay
            System.out.print("Enter a payrate: ");
            pay_rate = console.nextDouble();
            console.nextLine();

            //enter an amount of hours
            System.out.print("Enter # of hours: ");
            hours = console.nextInt();
            console.nextLine();

            //pad hours by 12
            hours += 12;

            calculator = new PayCalculator(pay_rate, name);
            pay = calculator.calculatePay(false, hours);

            System.out.println("Pay: $" + pay);
            System.out.println();

            //enter a name
            System.out.print("Enter a name: ");
            name = console.nextLine();

            //get a pay rate and print the pay
            System.out.print("Enter a payrate: ");
            pay_rate = console.nextDouble();
            console.nextLine();

            //enter an amount of hours
            System.out.print("Enter # of hours: ");
            hours = console.nextInt();
            console.nextLine();

            //pad hours by 12
            hours += 12;

            calculator = new PayCalculator(pay_rate, name);
            pay = calculator.calculatePay(false, hours);

            System.out.println("Pay: $" + pay);
            System.out.println();
        }
        catch (InputMismatchException ex)
        {
            //do nothing...
        }
        catch (Exception ex)
        {
            System.out.println("Error!");
        }
    }
}
