package BattleGame.Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the player to control their
 *  character (Actor).
 ***************************************/

import BattleGame.Actions.Heal;
import BattleGame.Actions.ICombatAction;
import BattleGame.Actor;
import BattleGame.IDescribable;
import BattleGame.UserInteraction.IValidate;
import BattleGame.UserInteraction.IsValidIndex;
import BattleGame.UserInteraction.Menu;
import BattleGame.UserInteraction.View;
import java.util.List;

public class Player extends Controller implements IController
{
    //fields

    //constructor
    public Player(Actor... characters)
    {
        super(characters);
    }

    //methods
    public void takeAction(Actor partyMember, List<Actor> availableTargets)
    {
        ICombatAction chosenAction = chooseAction(partyMember);

        List<Actor> filteredTargets = chosenAction instanceof Heal ? allies(availableTargets) : opponents(availableTargets);

        if(filteredTargets.size() > 1)
        {
            Actor chosenTarget = chooseTarget(filteredTargets);

            View.present(chosenAction.performAction(chosenTarget));
        }
        else
        {
            View.present(chosenAction.performAction(filteredTargets.get(0)));
        }
    }

    private ICombatAction chooseAction(Actor partyMember)
    {
        Menu menu = new Menu(partyMember.availableActions().toArray(new IDescribable[0]));
        IValidate menuValidation = new IsValidIndex(partyMember.availableActions());

        View.present("Choose your action...");

        return partyMember.availableActions().get(View.getIntResponse(menuValidation, menu.toString()) - 1);
    }

    private Actor chooseTarget(List<Actor> availableTargets)
    {
        Menu menu = new Menu(availableTargets.toArray(new IDescribable[0]));
        IValidate menuValidation = new IsValidIndex(availableTargets);

        View.present("Select your target...");

        return availableTargets.get(View.getIntResponse(menuValidation, menu.toString()) - 1);
    }
}