package lesson08;

public class Man implements Participant {
    private int maxLength;
    private int maxHeight;
    private boolean isLooser;


    public Man(int maxLength, int maxHeight) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        this.isLooser = false;
    }

    @Override
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Override
    public int getMaxLength() {
        return this.maxLength;
    }

    public boolean isLooser() {
        return isLooser;
    }

    @Override
    public void setLooser() {
        this.isLooser = true;
    }

    @Override
    public String toString() {
        return "Man(" +
                "L=" + maxLength +
                ", H=" + maxHeight +
                ')';
    }
}

