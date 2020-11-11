package Actions;

import CSIS1400.Actor;

public interface ICombatAction
{
    String getName();

    String getDescription();

    String performAction(Actor target);
}
