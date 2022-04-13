package lesson01;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
    }


    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    private static void checkSumSign() {
        int a = 3;
        int b = 7;
        int result = a + b;
        if(result >= 0 ) {
            System.out.println("Сумма положительная");
        } else
            System.out.println("Сумма отрицательная");
    }


}
