package lesson10;

public class Apple extends Fruit {
    private static final double ONE_APPLE_WEIGHT = 1;
    @Override
    public String toString() {
        return "Apple " + this.hashCode() ;
    }

    @Override
    public double getOneFruitWeight() {
        return ONE_APPLE_WEIGHT;
    }
}
