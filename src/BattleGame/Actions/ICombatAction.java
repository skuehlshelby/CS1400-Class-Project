package BattleGame.Actions;

/*******************************************************************
 * Description: An interface which stipulates that all actions performed
 *              in combat will have a name, description, and method of execution.
 *******************************************************************/

import BattleGame.Actor;
import BattleGame.IDescribable;

public interface ICombatAction extends IDescribable
{
    String performAction(Actor target);
}
