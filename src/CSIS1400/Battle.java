package CSIS1400;

/***************************************
 * Description: Manages turns between
 * IController objects, and returns the victor.
 * Participants take turns until only one
 * has live actors.
 ***************************************/

import Controllers.IController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Battle
{
    //fields
    private final IController[] participants;

    //constructor
    public Battle(IController...participants)
    {
        this.participants = participants;
    }

    //methods
    public IController fight()
    {
        do {
            for (IController participant : participants)
            {
                if(participant.getLiveActors().length > 0)
                {
                    participant.takeAction(getLiveActors());
                }
            }
        }while(participantsWithLiveActors().size() > 1);

        return participantsWithLiveActors().get(0);
    }

    private Actor[] getLiveActors()
    {
        ArrayList<Actor> liveActors = new ArrayList<>();

        for(IController participant : participants)
        {
            for(Actor actor : participant.getLiveActors())
            {
                liveActors.add(actor);
            }
        }

        return liveActors.toArray(new Actor[0]);
    }

    private ArrayList<IController> participantsWithLiveActors()
    {
        return Arrays.stream(participants)
                .filter(participant -> participant.getLiveActors().length > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}