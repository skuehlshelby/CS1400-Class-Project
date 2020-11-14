package CSIS1400;

import java.util.ArrayList;

public class IsValidIndex implements IValidate<Integer>
{
    private final int minValue;
    private final int maxValue;

    public IsValidIndex(int sizeOfList)
    {
        this.minValue = 1;
        this.maxValue = sizeOfList;
    }

    public boolean invalid(Integer input)
    {
        return input < minValue || input > maxValue;
    }

    public String help()
    {
        return String.format("Input must be a value between %d and %d.", minValue, maxValue);
    }
}
