package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;

import java.util.List;

public interface IAIStrategy
{
    ICombatAction getAction(Actor actor);

    Actor getTarget(List<Actor> availableTargets);
}
