package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;
import java.util.List;

public class Balanced extends AIStrategy implements IAIStrategy
{

    //fields

    //cstor

    //methods
    public ICombatAction getAction(Actor actor)
    {
        List<ICombatAction> availableActions = actor.availableActions();

        if(actor.getHealth().current() / actor.getHealth().maxValue() < 0.5)
        {
            if(!onlyHeals(availableActions).isEmpty())
            {
                return pickRandom(onlyHeals(availableActions));
            }
        }

        if(!onlyAttacks(availableActions).isEmpty())
        {
            return pickRandom(onlyAttacks(availableActions));
        }

        return pickRandom(availableActions);
    }

    public Actor getTarget(List<Actor> availableTargets)
    {
        return lowestHealth(availableTargets);
    }
}