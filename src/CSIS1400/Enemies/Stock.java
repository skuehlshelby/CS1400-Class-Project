package CSIS1400.Enemies;

import Actions.Attack;
import CSIS1400.Actor;
import Actions.Heal;

public class Stock
{
    //can attack
    public static final Actor giant = new Actor("Giant", "A hulking giant.",150.0,
            new Attack("Greatclub attack", "Smash your opponent.", 15.0, 20.0));

    //can attack & heal
    public static final Actor minotaur = new Actor("Minotaur","Half bull, half humanoid beast.",200.0,
            new Attack("Gore","Savagely gore your opponent.", 10.0,20.0),
            new Heal("Minor Heal", "magically heal", 20.0, 30.0));

    //can attack
    public static final Actor basilisk = new Actor("Basilisk", "A poisonous reptilian creature.", 125.0,
            new Attack("Bite", "A vicious bite attack.", 10.0, 15.0));

    //can attack
    public static final Actor giantSpider = new Actor("Giant Spider", "An eight-legged beast.", 130.0,
            new Attack("Bite", "A lethal piercing attack.", 15.0, 25.0));
}
