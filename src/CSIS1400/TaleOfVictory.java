package CSIS1400;

import Actions.Attack;
import Actions.Heal;
import CSIS1400.Enemies.Stock;
import Controllers.Computer;
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
                "The studliest of characters.",
                100.0,
                new Attack("Attack", "A stalwart slice at your foe...", 10.0, 20.0),
                new Attack("Big Attack", "This is a really big one...", 50.0, 100.0),
                new Heal("Drink Potion", "Restore a small amount of health...", 20.0, 50.0));

        Player player = new Player(mainCharacter);
        Computer comp = new Computer(Stock.minotaur, Stock.vampire);

        View.present(new Battle(player, comp).fight().getClass().toString());
    }
}
