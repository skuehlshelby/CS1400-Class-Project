package Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the player to control their
 *  character (Actor).
 ***************************************/

import CSIS1400.Actor;
import CSIS1400.IDescribable;
import CSIS1400.IsValidIndex;
import CSIS1400.View;
import java.util.List;

public class Player implements IController
{
    //fields
    private final Actor[] characters;

    //constructor
    public Player(Actor... characters)
    {
        this.characters = characters;
    }

    //methods
    public Actor[] getLiveActors()
    {
        return characters;
    }

    public void takeAction(Actor[] availableTargets)
    {
        for(Actor character : characters)
        {
            int chosenAction = View.getIntResponse(new IsValidIndex(character.getAvailableActions().length), View.convertToChoices(character.getAvailableActions()));
            int chosenTarget = View.getIntResponse(new IsValidIndex(availableTargets.length), View.convertToChoices(availableTargets));

            View.present(character.getAvailableActions()[chosenAction - 1].performAction(availableTargets[chosenTarget - 1]));
        }
    }
}
