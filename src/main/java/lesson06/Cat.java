package lesson06;


public class Cat extends Animal {
    private static int catCount;

    public Cat(int runDistance) {
        super(runDistance, 0);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public boolean swim(int distance) {
        System.out.println("ERR: Cat can't swim!");
        return false;
    }
}
