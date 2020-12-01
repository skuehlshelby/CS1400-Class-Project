package BattleGame.Controllers;

import BattleGame.Actor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Might not need this class. It's just a place to put methods that are shared between the player and the computer.
public abstract class Controller implements IController
{
    protected final Actor[] party;

    Controller(Actor... party)
    {
        this.party = party;
    }

    protected Actor[] partyMembers()
    {
        return party;
    }

    public Actor[] getLiveActors()
    {
        List<Actor> live = new ArrayList<>();

        for (Actor actor : party)
        {
            if (!actor.getHealth().isEmpty())
            {
                live.add(actor);
            }
        }

        return live.toArray(new Actor[0]);
    }

    protected Actor[] opponents(Actor[] actors)
    {
        List<Actor> partyMembers = Arrays.asList(partyMembers());
        List<Actor> opponents = new ArrayList<>();

        for (Actor element : actors)
        {
            if (!partyMembers.contains(element))
            {
                opponents.add(element);
            }
        }
        return opponents.toArray(new Actor[0]);
    }

    public abstract void takeAction(Actor[] availableTargets);
}