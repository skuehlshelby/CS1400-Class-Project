package Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the computer to control a
 *  character (Actor).
 ***************************************/

import CSIS1400.Actor;
import CSIS1400.View;
import java.util.Arrays;

public class Computer implements IController
{
    //fields
    private final Actor[] monsters;
    //cstor
    public Computer(Actor... monsters)
    {
        this.monsters = monsters;
    }

    //methods
    public Actor[] getLiveActors()
    {
        return Arrays.stream(monsters).filter(m -> !m.getHealth().isEmpty()).toArray(Actor[]::new);
    }

    public void takeAction(Actor[] availableTargets)
    {
        for(Actor monster : getLiveActors())
        {
            View.present(monster.getAvailableActions()[0].performAction(availableTargets[0]));
        }
    }
}
