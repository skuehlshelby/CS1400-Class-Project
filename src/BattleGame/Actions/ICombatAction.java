package BattleGame.Actions;

/*******************************************************************
 * Description: An interface which stipulates that all actions performed
 *              in combat will have a method of execution and be
 *              describable.
 *******************************************************************/

import BattleGame.Actor;
import BattleGame.IDescribable;

public interface ICombatAction extends IDescribable
{
    String performAction(Actor target);
}
