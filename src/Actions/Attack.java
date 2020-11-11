package Actions;

import CSIS1400.Actor;
import CSIS1400.Dice;

public class Attack implements ICombatAction
{
    private final String name;
    private final String description;
    private final Dice dice;

    public Attack(String name, String description, double minDamage, double maxDamage)
    {
        this.name = name;
        this.description = description;
        this.dice = new Dice(minDamage, maxDamage);
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String performAction(Actor target)
    {
        return String.format("%s took %s damage and has %f.2 health remaining!",
                target.getName(),
                target.getHealth().reduce(dice.roll()),
                target.getHealth().current());
    }
}
