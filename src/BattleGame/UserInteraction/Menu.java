package BattleGame.UserInteraction;

import BattleGame.IDescribable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*********************************************
 * Turns several IDescribable objects into a
 * neatly formatted menu, surrounded with a
 * border made of dashes.
 *********************************************/

public class Menu
{
    //fields
    private final String menu;

    //cstor
    public Menu(IDescribable... items)
    {
        List<String> menuItems = new ArrayList<>();
        int maxItemNameLength = maxLength(Arrays.stream(items).map(IDescribable::getName).collect(Collectors.toList()));

        for (int index = 0; index < items.length; index++)
        {
            menuItems.add(formatMenuItem(index + 1, maxItemNameLength, items[index].getName(), items[index].getDescription()));
        }

        String border = border(maxLength(menuItems));

        menuItems.add(0, border + '\n');
        menuItems.add(border);

        menu = menuItems.stream().reduce(String::concat).get();
    }

    private int maxLength(List<String> items)
    {
        return items.stream().map(String::length).max(Integer::compareTo).get();
    }

    private String formatMenuItem(int index, int columnWidth, String itemName, String itemDescription)
    {
        final String menuItemFormat = "%d. %-" + columnWidth + "s : %s\n";
        return String.format(menuItemFormat, index, itemName, capitalize(itemDescription));
    }

    private String capitalize(String item)
    {
        return item.substring(0, 1).toUpperCase() + item.substring(1);
    }

    private String border(int length)
    {
        char[] temp = new char[length + 1];
        Arrays.fill(temp, 0, length, '-');
        return new String(temp);
    }

    //methods
    public String toString()
    {
        return menu;
    }
}