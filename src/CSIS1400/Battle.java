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
    private final IController[] participants;

    public Battle(IController...participants)
    {
        this.participants = participants;
    }

    public IController fight()
    {
        do {
            for (IController participant : participants)
            {
                if(participant.getLiveActors().size() > 0)
                {
                    participant.takeAction(getLiveActors());
                }
            }
        }while(participantsWithLiveActors().size() > 1);

        return participantsWithLiveActors().get(0);
    }

    private ArrayList<Actor> getLiveActors()
    {
        ArrayList<Actor> liveActors = new ArrayList<>();

        Arrays.stream(participants).map(IController::getLiveActors).forEach(liveActors::addAll);

        return liveActors;
    }

    private ArrayList<IController> participantsWithLiveActors()
    {
        return Arrays.stream(participants)
                .filter(participant -> participant.getLiveActors().size() > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}