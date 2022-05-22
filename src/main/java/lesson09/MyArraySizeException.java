package lesson09;

public class MyArraySizeException extends Exception{
    public MyArraySizeException() {
        super("Array must be only 4x4 size!");
    }
}
