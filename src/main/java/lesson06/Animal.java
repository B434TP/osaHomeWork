package lesson06;

public abstract class Animal{
    private int runDistance;
    private int swimDistance;
    static private int animalCount;



    public Animal() {
        System.out.println("+1");
    }

    public Animal(int runDistance, int swimDistance) {
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        animalCount++;
    }

    public boolean swim(int distance){
        return swimDistance >= distance;
    }


    public boolean run(int distance){
        return runDistance >= distance;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
