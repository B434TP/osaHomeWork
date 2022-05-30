package lesson10;

public class WrongBoxTypeReloadException extends Exception {
    public WrongBoxTypeReloadException(String typeToReload, String typeToFill) {
        super("Box have wrong type, can't reload: " + typeToReload + " to: " + typeToFill);
    }
}
