package management;

public class PayCalculator
{
    double payAmount;
    String EmployeeFullName;

    public PayCalculator(double payAmount, String EmployeeFullName)
    {
        this.payAmount = payAmount;
        this.EmployeeFullName = EmployeeFullName;
    }

    public double calculatePay(boolean salaried, int hours)
    {
        if (salaried)
        {
            return payAmount;
        }
        else
        {
            double total = hours * payAmount;

            if (hours > 40)
            {
                total += hours * (0.5 * payAmount);
            }

            return total;
        }
    }

    public void printEmployee()
    {
        System.out.println(EmployeeFullName);
    }
}
