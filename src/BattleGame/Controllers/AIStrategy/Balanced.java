package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;

public class Balanced extends AIStrategy implements IAIStrategy
{
    public ICombatAction getAction(Actor actor)
    {
        ICombatAction[] availableActions = actor.getAvailableActions();

        if(actor.getHealth().current() / actor.getHealth().maxValue() < 0.5)
        {
            if(onlyHeals(availableActions).length > 0)
            {
                return pickRandom(onlyHeals(availableActions));
            }
        }

        if(onlyAttacks(availableActions).length > 0)
        {
            return pickRandom(onlyAttacks(availableActions));
        }

        return pickRandom(availableActions);
    }

    public Actor getTarget(Actor... availableTargets)
    {
        return lowestHealth(availableTargets);
    }
}