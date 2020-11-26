package CSIS1400;

import Actions.Attack;
import Actions.Heal;
import CSIS1400.Enemies.Stock;
import Controllers.Computer;
import Controllers.IController;
import Controllers.Player;

public class TaleOfVictory implements IStory
{
    //fields

    //cstor

    //methods
    public void tell() {
        //INTRODUCTION (just messing around right now, can change up later if we want!)
        View.present("You take a breath, readying yourself as you listen to the sound of",
                "thousands of voices cheering and yelling around the arena.",
                "The deafening voice of the announcer cuts through them all.",
                " ", "“And now, time for our last contestant in this year’s Victory Pit!",
                "Let’s see how they contend against our formidable beasts!”", " ",
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

        View.present(String.format("“%s! %s! %s!“", mainCharacter.getName(), mainCharacter.getName(), mainCharacter.getName()));
        View.present(" ", "More gates lift around you as various beasts come hurling out of them,",
                "setting you in their sights.", " ", "You charge towards them to meet their attack.", " ");

    /**FIRST BATTLE**/
        Player player = new Player(mainCharacter);
        Computer comp = new Computer(Stock.minotaur, Stock.giant);

        IController Victor = new Battle(player, comp).fight();

        //IF PLAYER WINGS
        if (Victor == player) {
            View.present("\nWith hardly a sweat upon your brow,",
                    "you watch the bodies of the beasts drop to the ground with a thud.",
                    "\n...But this battle is not yet over.",
                    "\nHearing sound of more enemies rushing near... you turn to face them.");
        }
        //IF PLAYER DIES
            else {
                View.present("\nYour opponents attack with a ferocious onslaught.",
                        "Not quick enough to block their attacks, you take hit after hit.",
                        "\nYour best isn't good enough.",
                        "\nCollapsing to the ground, you feel the life quickly drain out of you.");
                return;
        }

    /***** SECOND BATTLE ****/
        comp = new Computer(Stock.basilisk, Stock.giantSpider);
        Victor = new Battle(player, comp).fight();

        //IF PLAYER WINS
        if (Victor == player){
            View.present("\nYou stand, bloodied but alive, in the middle of the arena.",
                    "The corpses of hulking beasts lie around you, their blood seeping into the ground.",
                    "The resulting cheers of the crowd are thunderous.");

            View.present(String.format("%n“%s! %s! %s!“", mainCharacter.getName().toUpperCase(),
                    mainCharacter.getName().toUpperCase(), mainCharacter.getName().toUpperCase()));
            //TODO
            View.present("(add more here)");
        }
            //IF PLAYER DIES.
            else{
                View.present("\nThe beasts attack with a ferocious onslaught.",
                        "Not quick enough to block their attacks, you take hit after hit.",
                        "\nYour best isn't good enough.",
                        "\nCollapsing to the ground, you feel the life quickly drain out of you.");
                return;
        }
    }
}
