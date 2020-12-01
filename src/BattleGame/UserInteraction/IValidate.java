package BattleGame.UserInteraction;

/***************************************
 * Description: An interface which can
 * be implemented by classes that contain
 * validation logic. Good for validating
 * user input.
 ***************************************/

public interface IValidate<T>
{
    boolean invalid(T input);

    String help();
}
