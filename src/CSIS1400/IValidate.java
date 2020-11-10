package CSIS1400;

public interface IValidate<T>
{
    boolean invalid(T input);

    String help();
}
