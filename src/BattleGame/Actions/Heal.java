package BattleGame.Actions;

import BattleGame.Actor;
import BattleGame.Dice;

public class Heal implements ICombatAction
{

    //fields
    private final String name;
    private final String description;
    private final Dice dice;

    //cstor
    public Heal(String name, String description, double minHealing, double maxHealing)
    {
        this.name = name;
        this.description = description;
        this.dice = new Dice(minHealing, maxHealing);
    }

    //methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String performAction(Actor target) {

        double restoredHealth = dice.roll();

        if(restoredHealth >= target.getHealth().maxValue() - target.getHealth().current())
        {
            target.getHealth().increase(restoredHealth);

            return String.format("%s recovered %.2f health using %s and is now at full health!",
                    target.getName(),
                    restoredHealth,
                    getName());
        }
        else
        {
            return String.format("%s recovered %.2f health using %s and now has %.2f health remaining!",
                    target.getName(),
                    restoredHealth,
                    getName(),
                    target.getHealth().increase(restoredHealth));
        }
    }
}
