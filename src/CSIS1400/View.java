package CSIS1400;

import java.util.Scanner;

public class View
{
    private static Scanner scanner = new Scanner(System.in);

    public void present(String...lines)
    {
        for (String line : lines)
        {
            System.out.println(line);
        }
    }

    public int getIntResponse(String...prompt)
    {
        present(prompt);
        return scanner.nextInt();
    }

    public String getStringResponse(String...prompt)
    {
        present(prompt);
        return scanner.nextLine();
    }
}
