package lesson10;

public class FullBoxException extends Exception {
    public FullBoxException(String boxName, String fruit) {
        super("Box <" + boxName + "> is full already! Can't add fruit: " + fruit);
    }
}
