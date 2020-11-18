package CSIS1400;

/***************************************
 * Description: Keeps track of a value
 * which is bounded by zero and a
 * maximum value. Good for things like
 * health bars.
 ***************************************/

public class Indicator
{
    //fields
    private final double maxValue;
    private double currentValue;

    //constructor
    public Indicator(double maxValue)
    {
        this.maxValue = maxValue;
        this.currentValue = maxValue;
    }

    //methods
    public double current()
    {
        return currentValue;
    }

    public double reduce(double amount)
    {
        currentValue = Math.max(currentValue - amount, 0.0);
        return current();
    }

    public double increase(double amount)
    {
        currentValue = Math.min(currentValue + amount, maxValue);
        return current();
    }

    public double maxValue()
    {
        return this.maxValue;
    }

    public boolean isEmpty()
    {
        return current() <= 0.0;
    }
}
