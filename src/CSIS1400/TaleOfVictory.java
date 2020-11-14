package CSIS1400;

import Actions.Attack;
import Controllers.Player;

public class TaleOfVictory implements IStory
{

    //fields

    //cstor

    //methods
    public void tell() {

        Actor mainCharacter = new Actor(View.getStringResponse(
                "You awake in the street with no memory.",
                "A stranger yells in your general direction.",
                "...what did they call you again?"),
                "",
                100.0,
                new Attack("Attack", "A stalwart slice at your foe...", 10.0, 20.0));
        Player player = new Player(mainCharacter);

        View.present(new Battle(player).fight().getClass().toString());
    }
}
