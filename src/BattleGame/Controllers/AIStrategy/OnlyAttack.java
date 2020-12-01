package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;

public class OnlyAttack extends AIStrategy implements IAIStrategy
{
    public ICombatAction getAction(Actor actor)
    {
        return pickRandom(onlyAttacks(actor.getAvailableActions()));
    }

    public Actor getTarget(Actor... availableTargets)
    {
        return lowestHealth(availableTargets);
    }
}