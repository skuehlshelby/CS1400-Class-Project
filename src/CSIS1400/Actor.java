package CSIS1400;

/***************************************
 * Description: A repository for stats
 * and actions.
 ***************************************/

import Actions.ICombatAction;

public class Actor
{
    private final String name;
    private final Indicator health;
    private final ICombatAction[] availableActions;

    public Actor(String name, double maxHealth, ICombatAction... availableActions)
    {
        this.name = name;
        this.health = new Indicator(maxHealth);
        this.availableActions = availableActions;
    }

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
