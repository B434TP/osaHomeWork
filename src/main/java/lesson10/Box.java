package lesson10;

public class Box<E extends Fruit> {
    private static int MAX_SIZE = 6;
    private int currentSize;
    private String name;
    private String type;

    private E[] fruitsList;






    public void addFruit(E newFruit) throws FullBoxException {
        if (currentSize < MAX_SIZE) {

            fruitsList[currentSize] = newFruit;
            currentSize++;
        } else {
            throw new FullBoxException(this.name, newFruit.toString());
        }
    }


    public double getWeight() {
        double weight = 0;

        for (int i = 0; i < this.currentSize; i++) {
            weight += this.fruitsList[i].getOneFruitWeight();
        }
        return weight;
    }

    public Box(String name, String type) {
        this.fruitsList = (E[]) new Fruit[MAX_SIZE];
        this.currentSize = 0;
        this.name = name;
        this.type = type;
    }

    public void show() {
        String out = "";
        System.out.println("\n" + this.name);
        for (int i = 0; i < this.fruitsList.length; i++) {
            if (this.fruitsList[i] != null) {
                out = (this.fruitsList[i]).toString();
            } else {
                out = "<--->";
            }
            System.out.println((i + 1) + ". " + out);

        }

    }

    public boolean compare(Box anotherBox) {
        if (this.getWeight() == anotherBox.getWeight()) {
            return true;
        } else {
            return false;
        }
    }

    public void reload(Box boxToFill) throws WrongBoxTypeReloadException {

        if (this.type != boxToFill.getType()) {
            throw new WrongBoxTypeReloadException(this.type, boxToFill.getType());
        }

        for (int i = 0; i < currentSize; i++) {
            try {
                boxToFill.addFruit(this.getFruit(i));
            } catch (FullBoxException e) {
                e.printStackTrace();
            } catch (NoFruitException e) {
                e.printStackTrace();
            }
        }


    }

    public Fruit getFruit(int fruitIndex) throws NoFruitException {
        Fruit fruitToReturn;

        if (fruitsList[fruitIndex] != null){
            fruitToReturn = fruitsList[fruitIndex];
            fruitsList[fruitIndex] = null;
        } else {
            throw new NoFruitException(this.name);
        }
        return fruitToReturn;
    }

    public String getType() {
        return type;
    }
}
