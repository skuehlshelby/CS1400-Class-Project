package BattleGame.Controllers;

import BattleGame.Actor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*******************************************
 * A place to put logic which is used by
 * both human players and AI players.
 *******************************************/

public abstract class Controller implements IController
{
    protected final List<Actor> party;

    Controller(Actor... party)
    {
        this.party = Arrays.asList(party);
    }

    public List<Actor> getActors()
    {
        return party;
    }

    //Filters the supplied List of Actors and returns only actors who ARE NOT in this Controller's party.
    protected List<Actor> opponents(List<Actor> actors)
    {
        return actors.stream().filter(actor -> !party.contains(actor)).collect(Collectors.toList());
    }

    //Filters the supplied List of Actors and returns only actors who ARE in this Controller's party.
    protected List<Actor> allies(List<Actor> actors)
    {
        return actors.stream().filter(party::contains).collect(Collectors.toList());
    }

    public abstract void takeAction(Actor partyMember, List<Actor> availableTargets);
}