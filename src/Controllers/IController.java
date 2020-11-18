package Controllers;

/*************************************
 * Description: An interface which stipulates
 * that things which control Actors can
 * take actions.
 *************************************/

import CSIS1400.Actor;

public interface IController
{
    Actor[] getLiveActors();

    void takeAction(Actor[] availableTargets);
}
