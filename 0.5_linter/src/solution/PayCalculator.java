package solution;

/**
 * A class that calculates pay.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class PayCalculator
{
    public static final int OT_THRESHOLD = 40;
    public static final double OT_RATE = 0.5;
    private double payAmount;
    private String employeeFullName;

    /**
     * Creates a new calculator
     * @param payAmount the amount per hour or the salary value
     * @param employeeFullName the employee name
     */
    public PayCalculator(double payAmount, String employeeFullName)
    {
        this.payAmount = payAmount;
        this.employeeFullName = employeeFullName;
    }

    /**
     * Returns the pay total for the employee.
     * @param salaried is the employee salaried?
     * @param hours the hours worked
     * @return the pay amount
     */
    public double calculatePay(boolean salaried, int hours)
    {
        if (salaried)
        {
            return payAmount;
        }
        else
        {
            double total = hours * payAmount;

            if (hours > OT_THRESHOLD)
            {
                total += hours * (OT_RATE * payAmount);
            }

            return total;
        }
    }

    @Override
    public String toString()
    {
        return "payAmount=" + payAmount +
               ", EmployeeFullName='" + employeeFullName;
    }
}
