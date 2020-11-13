package CSIS1400;

import Actions.Attack;
import Controllers.Player;

public class Main
{
    public static void main(String[] args)
    {
        IStory Arena = new TaleOfVictory();
        Arena.tell();
    }
}
