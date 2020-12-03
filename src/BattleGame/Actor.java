package BattleGame;

/***************************************
 * Description: A repository for stats
 * and actions.
 ***************************************/

import BattleGame.Actions.ICombatAction;

import java.util.Arrays;
import java.util.List;

public class Actor implements IDescribable
{
    //fields
    private final String name;
    private final String description;
    private final Indicator health;
    private final List<ICombatAction> availableActions;

    //constructor
    public Actor(String name, String description, double maxHealth, ICombatAction... availableActions)
    {
        this.name = name;
        this.description = description;
        this.health = new Indicator(maxHealth);
        this.availableActions = Arrays.asList(availableActions);
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

    public Indicator getHealth()
    {
        return health;
    }

    public List<ICombatAction> availableActions()
    {
        return availableActions;
    }
}
