package BattleGame.Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the player to control their
 *  character (Actor).
 ***************************************/

import BattleGame.Actions.Heal;
import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;
import BattleGame.UserInteraction.IsValidIndex;
import BattleGame.UserInteraction.Menu;
import BattleGame.UserInteraction.View;

public class Player extends Controller implements IController
{
    //fields

    //constructor
    public Player(Actor... characters)
    {
        super(characters);
    }

    //methods
    public void takeAction(Actor[] availableTargets)
    {
        for(Actor character : getLiveActors())
        {
            View.present(" ", "Choose your action...");

            ICombatAction chosenAction = character.getAvailableActions()[View.getIntResponse(
                    new IsValidIndex(character.getAvailableActions()),
                    new Menu(character.getAvailableActions()).toString()) - 1];

            Actor[] targets = chosenAction.getClass() == Heal.class ? getLiveActors() : opponents(availableTargets);

            if(targets.length > 1)
            {
                View.present("Select your target...");

                Actor chosenTarget = targets[View.getIntResponse(
                        new IsValidIndex(targets),
                        new Menu(targets).toString()) - 1];

                View.present(chosenAction.performAction(chosenTarget));
            }
            else
            {
                View.present(chosenAction.performAction(targets[0]));
            }
        }
    }
}