package BattleGame.UserInteraction;

public class IsValidIndex implements IValidate<Integer>
{
    private final int minValue;
    private final int maxValue;

    public <T> IsValidIndex(T[] input)
    {
        this.minValue = 1;
        this.maxValue = input.length;
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
