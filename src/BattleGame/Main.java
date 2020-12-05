/***************
 * Partners: Scott Kuehl-Shelby & Allyson Quilter
 * Pebble Distribution: 50/50
 **************/

package BattleGame;

public class Main
{
    //Potential future direction: Multiple stories to choose from.
    public static void main(String[] args)
    {
        IStory Arena = new TaleOfVictory();
        Arena.tell();
    }
}
