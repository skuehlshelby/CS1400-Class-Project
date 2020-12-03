package BattleGame.UserInteraction;

import java.util.List;

public class IsValidIndex implements IValidate<Integer>
{
    private final int minValue;
    private final int maxValue;

    public <T> IsValidIndex(List<T> input)
    {
        this.minValue = 1;
        this.maxValue = input.size();
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
