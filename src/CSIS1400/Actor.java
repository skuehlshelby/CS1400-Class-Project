package CSIS1400;

/***************************************
 * Description: A repository for stats
 * and actions.
 ***************************************/

import Actions.ICombatAction;

public class Actor
{
    //fields
    private final String name;
    private final Indicator health;
    private final ICombatAction[] availableActions;

    //constructor
    public Actor(String name, double maxHealth, ICombatAction... availableActions)
    {
        this.name = name;
        this.health = new Indicator(maxHealth);
        this.availableActions = availableActions;
    }

    //methods
    public String getName()
    {
        return name;
    }

    public Indicator getHealth()
    {
        return health;
    }

    public ICombatAction[] getAvailableActions()
    {
        return availableActions;
    }
}
