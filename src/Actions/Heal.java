package Actions;

import CSIS1400.Actor;
import CSIS1400.Dice;

public class Heal implements ICombatAction
{

    private final String name;
    private final String description;
    private final Dice dice;

    public Heal(String name, String description, double minHealing, double maxHealing)
    {
        this.name = name;
        this.description = description;
        this.dice = new Dice(minHealing, maxHealing);
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String performAction(Actor target) {
        target.getHealth().increase(dice.roll());
        return String.format("%s drinks a health potion and now has %f.2 health remaining!",
                target.getName(),
                target.getHealth().current());

    }
}
