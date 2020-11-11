package Controllers;

import CSIS1400.Actor;
import java.util.Arrays;

//Might not need this class. It's just a place to put methods that are shared between the player and the computer.
abstract class ControllerHelpers
{
    protected final Actor me;

    ControllerHelpers(Actor me)
    {
        this.me = me;
    }

    protected Actor[] allButMe(Actor...actors)
    {
        return Arrays.stream(actors).filter(actor -> !actor.equals(me)).toArray(Actor[]::new);
    }
}
