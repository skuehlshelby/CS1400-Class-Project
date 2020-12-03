package BattleGame.Controllers;

import BattleGame.Actor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Might not need this class. It's just a place to put methods that are shared between the player and the computer.
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

    protected List<Actor> opponents(List<Actor> actors)
    {
        return actors.stream().filter(actor -> !party.contains(actor)).collect(Collectors.toList());
    }

    protected List<Actor> allies(List<Actor> actors)
    {
        return actors.stream().filter(party::contains).collect(Collectors.toList());
    }

    public abstract void takeAction(Actor partyMember, List<Actor> availableTargets);
}