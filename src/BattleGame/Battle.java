package BattleGame;

/***************************************
 * Description: Manages turns between
 * IController objects, and returns the victor.
 * Participants take turns until only one
 * has live actors.
 ***************************************/

import BattleGame.Controllers.IController;
import java.util.*;

public class Battle
{
    //fields
    private final Map<Actor, IController> actors = new HashMap<>();//Keeps track of what actors are controlled by who.

    //constructor
    public Battle(IController...participants)
    {
        //Populate the actor/controller tracker.
        for(IController participant : participants)
        {
            for (Actor actor : participant.getActors())
            {
                actors.put(actor, participant);
            }
        }
    }

    //methods
    public IController fight()
    {
        do {
            //Loops through all remaining actors. Uses an iterator to avoid a concurrent modification exception.
            for(Iterator<Actor> actorIterator = actors.keySet().iterator(); actorIterator.hasNext();)
            {
                Actor actor = actorIterator.next();

                //If the actor is alive, have them take an action. If they are dead, remove them from the list of participants.
                if(actor.getHealth().isEmpty())
                {
                    actorIterator.remove();

                    //Stop if victory is achieved.
                    if(onlyOneRemains())
                    {
                        break;
                    }
                }
                else
                {
                    actors.get(actor).takeAction(actor, new ArrayList<>(actors.keySet()));
                }
            }
        }while(!onlyOneRemains());

        //Return the victorious party.
        return actors.values().stream().findFirst().get();
    }

    //Check if more than one party has live actors.
    private boolean onlyOneRemains()
    {
        return actors.values().stream().distinct().count() == 1;
    }
}