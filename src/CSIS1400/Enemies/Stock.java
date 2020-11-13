package CSIS1400.Enemies;

import Actions.Attack;
import CSIS1400.Actor;

public class Stock
{
    public static final Actor vampire = new Actor("Vampire",
            150.0,
            new Attack("Suck Blood", "Eeek!", 15.0, 30.0));

    public static final Actor minotaur = new Actor("Minotaur",
            200.0,
            new Attack("Gore", "Savagely gore your opponent.", 10.0, 20.0));
}
