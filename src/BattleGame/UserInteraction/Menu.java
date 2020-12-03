package BattleGame.UserInteraction;

import BattleGame.IDescribable;

public class Menu
{
    private String menu = "";

    public Menu(IDescribable... items)
    {
        final String choiceFormat = "%d. %s: %s\n";
        int index = 1;

        for (IDescribable item : items)
        {
            menu += String.format(choiceFormat, index, item.getName(), item.getDescription());
            index++;
        }

        menu = menu.trim();
    }

    public String toString()
    {
        return menu;
    }
}