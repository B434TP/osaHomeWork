package lesson07;

public class Main {
    public static void main(String[] args) {

        Cat[] myCats = new Cat[6];
        Plate plate = new Plate(100);

        myCats[0] = new Cat("Petr", 15);
        myCats[1] = new Cat("Catty", 25);
        myCats[2] = new Cat("Arbuz", 7);
        myCats[3] = new Cat("BIG Barsik", 70);
        myCats[4] = new Cat("Lion", 25);
        myCats[5] = new Cat("Rosa", 30);

        System.out.println("\n");
        System.out.println(plate);

        System.out.println("\n");
        for (int i = 0; i < myCats.length; i++) {
            System.out.println(myCats[i]);
        }

        System.out.println("\n");
        for (int i = 0; i < myCats.length; i++) {
           if (myCats[i].feed(plate)){
               System.out.println(myCats[i].getName() + " is eating...");
           } else
               System.out.println(myCats[i].getName() + " didn't eat");

        }

        System.out.println("\n");
        for (int i = 0; i < myCats.length; i++) {
            System.out.println(myCats[i]);
        }

        System.out.println("\n");
        System.out.println(plate);

        System.out.println("\nAdding some food...");
        plate.addFood(50);
        System.out.println(plate);

    }

}
