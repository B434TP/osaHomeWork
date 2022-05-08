package lesson06;

public class Dog extends Animal{
    private static int dogCount;

    public Dog(int runDistance, int swimDistance) {
        super(runDistance, swimDistance);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
