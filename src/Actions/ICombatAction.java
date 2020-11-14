package Actions;

/*******************************************************************
 * Description: An interface which stipulates that all actions performed
 *              in combat will have a name, description, and method of execution.
 *******************************************************************/

import CSIS1400.Actor;
import CSIS1400.IDescribable;

public interface ICombatAction extends IDescribable
{
    String performAction(Actor target);
}
