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
    private final Map<Actor, IController> actors = new HashMap<>();

    //constructor
    public Battle(IController...participants)
    {
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
            for(Iterator<Actor> actorIterator = actors.keySet().iterator(); actorIterator.hasNext();)
            {
                Actor actor = actorIterator.next();

                if(actor.getHealth().isEmpty())
                {
                    actorIterator.remove();

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

        return actors.values().stream().findFirst().get();
    }

    private boolean onlyOneRemains()
    {
        return actors.values().stream().distinct().count() == 1;
    }
}