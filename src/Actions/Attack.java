package Actions;

/*******************************************************************
 * Description: An action that deals damage to a target (an Actor).
 *              Information about the attack is defined in the constructor.
 *******************************************************************/

import CSIS1400.Actor;
import CSIS1400.Dice;

public class Attack implements ICombatAction
{
    //fields
    private final String name;
    private final String description;
    private final Dice dice;

    //cstor
    public Attack(String name, String description, double minDamage, double maxDamage)
    {
        this.name = name;
        this.description = description;
        this.dice = new Dice(minDamage, maxDamage);
    }

    //methods
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
