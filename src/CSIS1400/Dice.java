package CSIS1400;

import java.util.Random;

public class Dice
{
    private final double min;
    private final double max;
    private final Random rand;

    public Dice(double min, double max)
    {
        this.min = min;
        this.max = max;
        this.rand = new Random();
    }

    public double roll()
    {
        return rand.nextDouble() * (max - min) + min;
    }
}
