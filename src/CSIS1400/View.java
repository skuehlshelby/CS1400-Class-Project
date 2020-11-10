package CSIS1400;

import java.util.Scanner;

public class View
{
    private static final Scanner scanner = new Scanner(System.in);

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

    public int getIntResponse(IValidate<Integer> validation, String...prompt)
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

    public String getStringResponse(String...prompt)
    {
        present(prompt);
        return scanner.nextLine();
    }

    public String getStringResponse(IValidate<String> validation, String...prompt)
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