package BattleGame.Controllers.AIStrategy;

import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;
import java.util.List;

/***************************************
 * Stipulates that an AI-player will use
 * these methods to decide what they
 * should do.
 ***************************************/

public interface IAIStrategy
{
    ICombatAction getAction(Actor actor);

    Actor getTarget(List<Actor> availableTargets);
}
