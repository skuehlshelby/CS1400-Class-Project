package Controllers;

/*************************************
 * Description: An interface which stipulates
 * that things which control Actors can
 * take actions.
 *************************************/

import CSIS1400.Actor;

import java.util.ArrayList;

public interface IController
{
    ArrayList<Actor> getLiveActors();

    void takeAction(ArrayList<Actor> availableTargets);
}
