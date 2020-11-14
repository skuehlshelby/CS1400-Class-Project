package CSIS1400;

/***************************************
 * Description: A repository for stats
 * and actions.
 ***************************************/

import Actions.ICombatAction;

public class Actor implements IDescribable
{
    //fields
    private final String name;
    private final String description;
    private final Indicator health;
    private final ICombatAction[] availableActions;

    //constructor
    public Actor(String name, String description, double maxHealth, ICombatAction... availableActions)
    {
        this.name = name;
        this.description = description;
        this.health = new Indicator(maxHealth);
        this.availableActions = availableActions;
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

    public ICombatAction[] getAvailableActions()
    {
        return availableActions;
    }
}
