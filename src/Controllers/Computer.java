package Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the computer to control a
 *  character (Actor).
 ***************************************/

import CSIS1400.Actor;
import java.util.ArrayList;

public class Computer extends ControllerHelpers implements IController
{
    //fields

    //cstor
    Computer(Actor me)
    {
        super(me);
    }

    //methods
    public ArrayList<Actor> getLiveActors() {
        return null;
    }

    public void takeAction(ArrayList<Actor> availableTargets)
    {
        me.getAvailableActions()[1].performAction(availableTargets.get(0));
    }
}
