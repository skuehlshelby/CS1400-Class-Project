package BattleGame.Actions;

/*******************************************************************
 * Description: An action that deals damage to a target (an Actor).
 *              Information about the attack is defined in the constructor.
 *******************************************************************/

import BattleGame.Actor;
import BattleGame.Dice;

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
        double damage = dice.roll();

        if(damage >= target.getHealth().current())
        {
            target.getHealth().reduce(damage);

            return String.format("%s takes %.2f damage from %s and now lies dead...",
                    target.getName(),
                    damage,
                    getName());
        }
        else
        {
            return String.format("%s takes %.2f damage from %s and has %.2f health remaining!",
                    target.getName(),
                    damage,
                    getName(),
                    target.getHealth().reduce(damage));
        }
    }
}
