package Controllers;

import CSIS1400.Actor;

public interface IController
{
    void takeAction(Actor...availableTargets);
}
