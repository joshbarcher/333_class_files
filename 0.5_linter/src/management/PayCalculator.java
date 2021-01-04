package management;

public class PayCalculator
{
    double pay;
    String EmployeeFullName;

    public PayCalculator(double pay, String EmployeeFullName)
    {
        this.pay = pay;
        this.EmployeeFullName = EmployeeFullName;
    }

    public double calculatePay(boolean salaried, int hours)
    {
        if (salaried)
        {
            return pay;
        }
        else
        {
            double total = hours * pay;

            if (hours > 40)
            {
                total += hours * (0.5 * pay);
            }

            return total;
        }
    }

    public void printEmployee()
    {
        System.out.println(EmployeeFullName);
    }
}
