package CSIS1400;

import Actions.Attack;
import Actions.Heal;
import CSIS1400.Enemies.Stock;
import Controllers.Computer;
import Controllers.Player;

public class TaleOfVictory implements IStory
{
    View story = new View();
    //fields

    //cstor

    //methods
    public void tell() {

        //INTRODUCTION (just messing around right now, can change up later if we want!)
        story.present("You take a breath, readying yourself as you listen to the sound of",
                "thousands of voices cheering and yelling around the arena.",
                "The deafening voice of the announcer cuts through them all.",
                " ", "“And now, time for our last contestant in this year’s Victory Pit!",
                "Let’s see how they contend against our favorite beasts!”", " ",
                "The gate before you lifts, and you step into the large circular arena.",
                "The crowd cheers your name, louder and louder.", " ");

        //getting character name
        Actor mainCharacter = new Actor(View.getStringResponse(
                "(What name is the crowd cheering?)"),
                "A legendary fighter.",
                150.0,
                new Attack("Flurry of Blows", "A whirlwind of attacks against your foe...", 15.0, 25.0),
                new Attack("Fire Bolt", "A powerful bolt of fire magic...", 50.0, 100.0),
                new Heal("Cure Wounds", "Restore a small amount of health...", 50.0, 70.0));

        story.present(String.format("“%s! %s! %s!“", mainCharacter.getName(), mainCharacter.getName(), mainCharacter.getName()));
        story.present(" ", "More gates lift all around you as various beasts come hurling out of them,",
                "setting you in their sights.", " ", "You charge towards them to meet their attack.", " ");

    /**FIRST BATTLE**/

        Player player = new Player(mainCharacter);
        Computer comp = new Computer(Stock.minotaur, Stock.giant);

        do {
            View.present(new Battle(player, comp).fight().getClass().toString()); //battle starts

            if (Stock.minotaur.getHealth().current() <= 0 && Stock.giant.getHealth().current() <= 0) {
                story.present(String.format("%nThe giant and minotaur lay dead at your feet.%n"));
            }
        }while(Stock.giant.getHealth().current() > 0 && Stock.minotaur.getHealth().current() > 0 && mainCharacter.getHealth().current() > 0);

    /***** SECOND BATTLE ****/

        if (mainCharacter.getHealth().current() > 0){
            story.present("You hear sound of more enemies approaching... you turn to face them.");

            Player player1 = new Player(mainCharacter);
            Computer comp1 = new Computer(Stock.basilisk, Stock.giantSpider);

            View.present(new Battle(player1, comp1).fight().getClass().toString());
        }

        if (mainCharacter.getHealth().current() > 0){
            story.present("\nYou stand victorious!");
        }
            else{
                story.present("\nYour best wasn't good enough.", "You lie dead in the sand");
        }
    }
}
