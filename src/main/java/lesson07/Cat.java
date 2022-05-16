package lesson07;

public class Cat {

    private String name;
    private int maxFood;
    private boolean isFull;

    public Cat(String name,  int maxFood) {
        this.name = name;
        this.maxFood = maxFood;
        this.isFull = false;
    }

    public boolean feed(Plate plate){
            if (plate.getCurrentFoodCount() - maxFood >= 0){
                plate.getFood(maxFood);
                isFull = true;
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", maxFood=" + maxFood +
                ", isFull=" + isFull +
                '}';
    }

    public String getName() {
        return name;
    }
}
