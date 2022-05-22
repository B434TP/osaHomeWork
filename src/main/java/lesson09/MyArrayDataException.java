package lesson09;

public class MyArrayDataException extends Exception{

    public MyArrayDataException(int i, int j) {
        super("Item [" + i + ", " + j + "] isn't integer" );
    }
}
