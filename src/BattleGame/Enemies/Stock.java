package BattleGame.Enemies;

import BattleGame.Actions.Attack;
import BattleGame.Actor;
import BattleGame.Actions.Heal;

public class Stock
{
    //Enemy 1
    public static final Actor giant = new Actor("Giant", "A hulking giant.",150.0,
            new Attack("Great-Club Attack", "the giant's club attack", 15.0, 20.0));

    //Enemy 2
    public static final Actor minotaur = new Actor("Minotaur","Half bull, half humanoid beast.",200.0,
            new Attack("Gore","the minotaur's horned attack", 10.0,20.0),
            new Heal("Minor Heal", "magically heal", 20.0, 30.0));

    //Enemy 3
    public static final Actor basilisk = new Actor("Basilisk", "A poisonous reptilian creature.", 125.0,
            new Attack("Bite", "a poisonous bite from the basilisk", 10.0, 15.0));

    //Enemy 4
    public static final Actor giantSpider = new Actor("Giant Spider", "An eight-legged beast.", 130.0,
            new Attack("Bite", "the spiders lethal piercing attack", 15.0, 25.0));
}
