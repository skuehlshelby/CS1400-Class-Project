package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.Attack;
import BattleGame.Actions.Heal;
import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*******************************************
 * Contains helper methods specifically for
 * creating AI types. Not meant to be used
 * by human players.
 *******************************************/

public abstract class AIStrategy
{
    private final Random rand = new Random();

    protected <T> T pickRandom(List<T> availableActions)
    {
        return availableActions.get(rand.nextInt(availableActions.size()));
    }

    protected List<ICombatAction> onlyAttacks(List<ICombatAction> availableActions)
    {
        return availableActions.stream().filter(action -> action instanceof Attack).collect(Collectors.toList());
    }

    protected List<ICombatAction> onlyHeals(List<ICombatAction> availableActions)
    {
        return availableActions.stream().filter(action -> action instanceof Heal).collect(Collectors.toList());
    }

    protected Actor lowestHealth(List<Actor> availableTargets)
    {
        return availableTargets.stream().min(Comparator.comparingDouble(actor -> actor.getHealth().current())).get();
    }
}