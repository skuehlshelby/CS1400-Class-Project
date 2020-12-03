package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;

import java.util.List;

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