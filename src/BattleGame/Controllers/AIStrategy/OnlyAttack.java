package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;
import java.util.List;

/***************************************
 * Logic (or lack thereof) for an AI player
 * who only attacks.
 ***************************************/

public class OnlyAttack extends AIStrategy implements IAIStrategy
{
    public ICombatAction getAction(Actor actor)
    {
        return pickRandom(onlyAttacks(actor.availableActions()));
    }

    public Actor getTarget(List<Actor> availableTargets)
    {
        return lowestHealth(availableTargets);
    }
}