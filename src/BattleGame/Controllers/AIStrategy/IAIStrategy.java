package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;

public interface IAIStrategy
{
    ICombatAction getAction(Actor actor);

    Actor getTarget(Actor... availableTargets);
}
