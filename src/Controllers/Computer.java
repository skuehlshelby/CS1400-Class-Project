package Controllers;

/***************************************
 * Description: Contains the logic needed
 *  to allow the computer to control a
 *  character (Actor).
 ***************************************/

import CSIS1400.Actor;

public class Computer extends ControllerHelpers implements IController
{
    //fields

    //cstor
    Computer(Actor me)
    {
        super(me);
    }

    //methods
    public Actor[] getLiveActors() {
        return null;
    }

    public void takeAction(Actor[] availableTargets)
    {
        me.getAvailableActions()[0].performAction(availableTargets[0]);
    }
}
