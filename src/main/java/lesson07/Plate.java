package lesson07;

public class Plate {

    private int capacity;
    private int currentFoodCount;

    public Plate(int capacity) {
        this.capacity = capacity;
        this.currentFoodCount = capacity;
    }

    public boolean getFood(int foodToEatCount){

        if (currentFoodCount - foodToEatCount < 0){
            return false;
        } else {
            currentFoodCount = currentFoodCount - foodToEatCount;
            return true;
        }


    }

    public int getCurrentFoodCount() {
        return currentFoodCount;
    }



    @Override
    public String toString() {
        return "Plate{" +
                "capacity=" + capacity +
                ", currentFoodCount=" + currentFoodCount +
                '}';
    }

    public void addFood(int foodToAdd) {
        currentFoodCount = currentFoodCount + foodToAdd;
    }
}
