package Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the player to control their
 *  character (Actor).
 ***************************************/

import CSIS1400.Actor;
import CSIS1400.IsValidIndex;
import CSIS1400.View;
import java.util.Arrays;

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
        return Arrays.stream(characters).filter(c -> !c.getHealth().isEmpty()).toArray(Actor[]::new);
    }

    public void takeAction(Actor[] availableTargets)
    {
        for(Actor character : characters)
        {
            View.present(String.format("%nChoose your action..."));
            int chosenAction = View.getIntResponse(new IsValidIndex(character.getAvailableActions().length), View.convertToChoices(character.getAvailableActions()));

            View.present(String.format("%nSelect your target..."));
            int chosenTarget = View.getIntResponse(new IsValidIndex(availableTargets.length), View.convertToChoices(availableTargets));

            View.present(character.getAvailableActions()[chosenAction - 1].performAction(availableTargets[chosenTarget - 1]));
        }
    }
}
