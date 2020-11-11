package Controllers;

import CSIS1400.Actor;

public class Computer extends ControllerHelpers implements IController
{
    Computer(Actor me)
    {
        super(me);
    }

    public void takeAction(Actor... availableTargets)
    {
        me.getAvailableActions()[1].performAction(availableTargets[1]);
    }
}
