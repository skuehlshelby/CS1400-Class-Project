package CSIS1400;

/***************************************
 * Description: Contains methods for
 * presenting things to the user and
 * getting responses from the user.
 ***************************************/

import java.util.Scanner;

public class View
{
    //fields

    //cstor

    //methods
    private static final Scanner scanner = new Scanner(System.in);

    public static void present(String...lines)
    {
        for (String line : lines)
        {
            System.out.println(line);
        }
    }

    public static int getIntResponse(String...prompt)
    {
        present(prompt);
        return scanner.nextInt();
    }

    public static int getIntResponse(IValidate<Integer> validation, String...prompt)
    {
        int response;

        present(prompt);

        do {
            response = scanner.nextInt();

            if(validation.invalid(response))
            {
                present(validation.help());
            }
        } while (validation.invalid(response));

        return response;
    }

    public static String getStringResponse(String...prompt)
    {
        present(prompt);
        return scanner.nextLine();
    }

    public static String getStringResponse(IValidate<String> validation, String...prompt)
    {
        String response;

        present(prompt);

        do {
            response = scanner.nextLine();

            if(validation.invalid(response))
            {
                present(validation.help());
            }
        } while (validation.invalid(response));

        return response;
    }
}