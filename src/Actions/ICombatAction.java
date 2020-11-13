package Actions;

/*******************************************************************
 * Description: An interface which stipulates that all actions performed
 *              in combat will have a name, description, and method of execution.
 *******************************************************************/

import CSIS1400.Actor;

public interface ICombatAction
{
    String getName();

    String getDescription();

    String performAction(Actor target);
}
