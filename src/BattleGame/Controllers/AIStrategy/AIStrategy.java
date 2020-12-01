package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.Attack;
import BattleGame.Actions.Heal;
import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;

import java.util.Arrays;
import java.util.Random;

public abstract class AIStrategy
{
    private final Random rand = new Random();

    protected <T> T pickRandom(T[] availableActions)
    {
        return availableActions[rand.nextInt(availableActions.length)];
    }

    protected ICombatAction[] onlyAttacks(ICombatAction... availableActions)
    {
        return Arrays.stream(availableActions).filter(action -> action instanceof Attack).toArray(ICombatAction[]::new);
    }

    protected ICombatAction[] onlyHeals(ICombatAction... availableActions)
    {
        return Arrays.stream(availableActions).filter(action -> action instanceof Heal).toArray(ICombatAction[]::new);
    }

    protected Actor lowestHealth(Actor... availableTargets)
    {
        Actor closestToDeath = availableTargets[0];

        for(Actor actor : availableTargets)
        {
            if (actor.getHealth().current() < closestToDeath.getHealth().current())
            {
                closestToDeath = actor;
            }
        }

        return closestToDeath;
    }
}
