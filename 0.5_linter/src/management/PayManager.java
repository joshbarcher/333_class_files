package management;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class PayManager
{
    private String name;

    public void main(String[] args)
    {
        //test our pay calculator
        try (Scanner console = new Scanner(System.in))
        {
            //enter a name
            System.out.println("Enter a name: ");
            name = console.nextLine();
            System.out.println("Your name is: " + name);

            //get a pay rate and print the pay
            double payRate = console.nextDouble();
            PayCalculator calculator = new PayCalculator(22.0, name);
            double pay = calculator.calculatePay(false, 55);

            System.out.println("Pay: " + pay);
        }
        catch (InputMismatchException ex)
        {
            //do nothing...
        }
        catch (Exception ex)
        {
            System.out.println("Error!");
        }

        //run a second test
        try (Scanner console = new Scanner(System.in))
        {
            //enter a name
            System.out.println("Enter a name: ");
            name = console.nextLine();
            System.out.println("Your name is: " + name);

            //get a pay rate and print the pay
            double payRate = console.nextDouble();
            PayCalculator calculator = new PayCalculator(22.0, name);
            double pay = calculator.calculatePay(false, 55);

            System.out.println("Pay: " + pay);
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
