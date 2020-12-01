package BattleGame.Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the computer to control a
 *  character (Actor).
 ***************************************/

import BattleGame.Actions.Attack;
import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;
import BattleGame.UserInteraction.View;
import BattleGame.Controllers.AIStrategy.Balanced;
import BattleGame.Controllers.AIStrategy.IAIStrategy;

public class Computer extends Controller implements IController
{
    //fields
    private final IAIStrategy strategy;

    //cstor
    public Computer(Actor... monsters)
    {
        this(new Balanced(), monsters);
    }

    public Computer(IAIStrategy strategy, Actor... monsters)
    {
        super(monsters);
        this.strategy = strategy;
    }

    //methods
    public void takeAction(Actor[] availableTargets)
    {
        for(Actor monster : getLiveActors())
        {
            ICombatAction chosenAction = strategy.getAction(monster);
            Actor chosenTarget;

            if(chosenAction instanceof Attack)
            {
                chosenTarget = strategy.getTarget(opponents(availableTargets));
            }
            else
            {
                chosenTarget = strategy.getTarget(partyMembers());
            }

            View.present(chosenAction.performAction(chosenTarget));
        }
    }
}