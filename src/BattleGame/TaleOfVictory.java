package BattleGame;

import BattleGame.Actions.Attack;
import BattleGame.Actions.Heal;
import BattleGame.UserInteraction.View;
import BattleGame.Enemies.Stock;
import BattleGame.Controllers.Computer;
import BattleGame.Controllers.IController;
import BattleGame.Controllers.Player;

public class TaleOfVictory implements IStory
{
    //fields

    //cstor

    //methods
    public String getName()
    {
        return "A Tale of Victory";
    }

    public String getDescription()
    {
        return "A glorious tale of brave arena fighters.";
    }

    public void tell() {
        //INTRODUCTION
        View.present("You take a breath, readying yourself as you listen to the sound of",
                "thousands of voices cheering and yelling around the arena.",
                "The deafening voice of the announcer cuts through them all.",
                " ", "“And now, time for our last contestant in this year’s Victory Pit!",
                "Let’s see how they contend against our formidable beasts!”", " ",
                "The gate before you lifts, and you step into the large circular arena.",
                "The crowd cheers your name, louder and louder.", " ");

        //GETTING CHARACTER NAME
        Actor mainCharacter = new Actor(View.getStringResponse(
                "(What name is the crowd cheering?)"),
                "A legendary fighter.",
                150.0,
                new Attack("Flurry of Blows", "a whirlwind of attacks", 25.0, 35.0),
                new Attack("Fire Bolt", "a powerful bolt of fire magic", 40.0, 70.0),
                new Heal("Cure Wounds", "restores a small amount of health", 50.0, 70.0));

        View.present(String.format("“%s! %s! %s!“", mainCharacter.getName(), mainCharacter.getName(),
                mainCharacter.getName()));
        View.present(" ", "More gates lift around you as various beasts come hurling out of them.",
                "They set you in their sights and quickly advance towards you.", " ",
                "One of them is a hulking giant, a greatclub clutched in its hand.",
                "The other is a towering minotaur with long lethal horns.",
                " ", "You charge towards each other.",
                "\nClashing in the middle of the arena, the minotaur makes the first attack.", " ", " ");

        //FIRST BATTLE
        Player player = new Player(mainCharacter);
        Computer comp = new Computer(Stock.minotaur, Stock.giant);

        IController Victor = new Battle(player, comp).fight();

        //IF PLAYER WINS
        if (Victor == player) {
            View.present("\nWith hardly a sweat upon your brow,",
                    "you watch the bodies of the beasts drop to the ground with a thud.",
                    "\nBut this battle is not yet over.",
                    "\nHearing sound of more enemies rushing near... you turn to face them.",
                    "An enormous hairy spider crawls towards you on eight long legs.",
                    "Alongside it is a large slithering basilisk.",
                    "\nYou dash forwards to meet their attack.");
        }
            //IF PLAYER DIES
            else {
                View.present("\nYour opponents attack with a ferocious onslaught.",
                        "Not quick enough to block their attacks, you take hit after hit.",
                        "\nYour best isn't good enough.",
                        "\nCollapsing to the ground, you feel the life quickly drain out of you.");
                return;
        }

        //SECOND BATTLE
        comp = new Computer(Stock.basilisk, Stock.giantSpider);
        Victor = new Battle(player, comp).fight();

        //IF PLAYER WINS
        if (Victor == player){
            View.present("\nYou stand, bloodied but alive, in the middle of the arena.",
                    "The corpses of hulking beasts lie around you, their blood seeping into the ground.",
                    "The resulting cheers of the crowd are thunderous.");

            View.present(String.format("%n“%s! %s! %s!“", mainCharacter.getName().toUpperCase(),
                    mainCharacter.getName().toUpperCase(), mainCharacter.getName().toUpperCase()));

            View.present("\nWith another win under your belt, you leave the arena laden with gold and gifts..",
                    "already anticipating next year's fight.");
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