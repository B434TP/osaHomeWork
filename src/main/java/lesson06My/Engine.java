package lesson06My;

public class Engine {
    int Power;
    double Volume;
    fuelType fuelType;
    String releaseYear;

    public Engine(int power, double volume, fuelType fuelType, String releaseYear) {
        Power = power;
        Volume = volume;
        this.fuelType = fuelType;
        this.releaseYear = releaseYear;
    }

    public enum fuelType {gasoline, diesel}
}
