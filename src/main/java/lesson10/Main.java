package lesson10;

public class Main {
    public static void main(String[] args) {

        swapperTest();

        boxesTest();


    }

    private static void boxesTest() {
        Box<Apple> boxForApple1 = new Box<>("First apple box", Apple.class.getName());
        Box<Apple> boxForApple2 = new Box<>("Second apple box", Apple.class.getName());
        Box<Orange> boxForOrange1 = new Box<>("First orange box", Orange.class.getName());
        Box<Orange> boxForOrange2 = new Box<>("Second orange box", Orange.class.getName());

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        Apple apple7 = new Apple();
        Apple apple8 = new Apple();
        Apple[] firstApplesSet = {apple1, apple2, apple3, apple4, apple5, apple6, apple7};
        Apple[] secondApplesSet = {apple7, apple8};


        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange[] orangesSet = {orange1, orange2, orange3 , orange4};


        boxForApple1.show();
        System.out.println("weight = " + boxForApple1.getWeight());

        for (Apple item: firstApplesSet
             ) {
            try {
                boxForApple1.addFruit(item);
            } catch (FullBoxException e) {
                e.printStackTrace();
            }
        }
        boxForApple1.show();
        System.out.println("weight = " + boxForApple1.getWeight());


        for (Apple item: secondApplesSet
             ) {
            try {
                boxForApple2.addFruit(item);
            } catch (FullBoxException e) {
                e.printStackTrace();
            }
        }

        boxForApple2.show();
        System.out.println("weight = " + boxForApple2.getWeight());


        for (Orange item: orangesSet
             ) {
            try {
                boxForOrange1.addFruit(item);
            } catch (FullBoxException e) {
                e.printStackTrace();
            }
        }
        boxForOrange1.show();
        System.out.println("weight = " + boxForOrange1.getWeight());

        System.out.print("Comparing weights of first and second boxes with apples: ");
        System.out.println(boxForApple1.compare(boxForApple2));
        System.out.print("Comparing weights of first box with apples with first box with oranges: ");
        System.out.println(boxForApple1.compare(boxForOrange1));


        System.out.println("\nRemoving one apple from box");
        boxForApple1.show();
        Apple oneApple = null;
        oneApple = (Apple) boxForApple1.getFruit(2);

        boxForApple1.show();

        System.out.println("\nBack one apple to box");

        try {
            boxForApple1.addFruit(oneApple);
        } catch (FullBoxException e) {
            e.printStackTrace();
        }
        boxForApple1.show();


        System.out.println("\nReloading fruits from one box to another");
        boxForOrange1.show();
        try {
            boxForOrange1.reload(boxForOrange2);
        } catch (WrongBoxTypeReloadException e) {
            e.printStackTrace();
        }
        boxForOrange1.show();
        boxForOrange2.show();

        try {
            boxForApple2.reload(boxForOrange2);
        } catch (WrongBoxTypeReloadException e) {
            e.printStackTrace();
        }
    }


    private static void swapperTest() {
        String[] myStringArr = {"one", "two", "tree", "four", "five"};

        ElementsSwapper<String> stringSwapper = new ElementsSwapper<>(myStringArr);

        stringSwapper.printArr();

        stringSwapper.swap(0, 3);

        stringSwapper.printArr();

        Integer[] myIntegerArr = {1, 2, 3, 4, 5};

        ElementsSwapper<Integer> integerSapper = new ElementsSwapper<>(myIntegerArr);

        integerSapper.printArr();

        integerSapper.swap(2,3);

        integerSapper.printArr();
    }


}
