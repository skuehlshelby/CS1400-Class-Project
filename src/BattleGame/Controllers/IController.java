package BattleGame.Controllers;

import BattleGame.Actor;
import java.util.List;

/*************************************
 * Description: An interface which stipulates
 * that things which control Actors can
 * take actions and must show the actors
 * they control.
 *************************************/

public interface IController
{
    //Show all actors, dead or alive
    List<Actor> getActors();


    //Have the supplied party member take an action.
    void takeAction(Actor partyMember, List<Actor> availableTargets);
}
