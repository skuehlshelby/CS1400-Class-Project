package BattleGame.Controllers;

/*************************************
 * Description: An interface which stipulates
 * that things which control Actors can
 * take actions.
 *************************************/

import BattleGame.Actor;

public interface IController
{
    Actor[] getLiveActors();

    void takeAction(Actor[] availableTargets);
}
