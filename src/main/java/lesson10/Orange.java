package lesson10;

public class Orange extends Fruit {
    private static final double ONE_ORANGE_WEIGHT = 1.5;
    @Override
    public String toString() {
        return "Orange " + this.hashCode();
    }

    @Override
    public double getOneFruitWeight() {
        return ONE_ORANGE_WEIGHT;
    }
}
