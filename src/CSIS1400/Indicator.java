package CSIS1400;

public class Indicator
{
    private final double maxValue;
    private double currentValue;

    public Indicator(double maxValue)
    {
        this.maxValue = maxValue;
        this.currentValue = maxValue;
    }

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

    public boolean isEmpty()
    {
        return current() <= 0.0;
    }
}
