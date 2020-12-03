package BattleGame.Controllers;

/*************************************
 * Description: An interface which stipulates
 * that things which control Actors can
 * take actions.
 *************************************/

import BattleGame.Actor;

import java.util.List;

public interface IController
{
    List<Actor> getActors();

    void takeAction(Actor partyMember, List<Actor> availableTargets);
}
