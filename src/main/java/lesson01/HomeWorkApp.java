package lesson01;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }


    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    private static void checkSumSign() {
        int a = 3;
        int b = -3;
        int result = a + b;
        if(result >= 0 ) {
            System.out.println("Сумма положительная");
        } else
            System.out.println("Сумма отрицательная");
    }


    private static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else System.out.println("Зелёный");
    }

    private static void compareNumbers() {
        int a = 13;
        int b = 47;
        if (a >= b) {
            System.out.println("a >= b");
        } else System.out.println("a < b");
    }


}
