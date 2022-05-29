package lesson10;

public class NoFruitException extends Exception{
    public NoFruitException(String name) {
        super("Can't find fruit in box: " + name);
    }
}
