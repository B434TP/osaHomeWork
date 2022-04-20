package lesson02;

public class SecondLesson {
    public static void main(String[] args) {

    // Задание 1
        System.out.println(checkSum(4, 5));
        System.out.println(checkSum(11, 5));
        System.out.println(checkSum(16, 5));

    // Задание 2
        checkInt(5);
        checkInt(0);
        checkInt(-3);

    // Задание 3
        isNegative(-1);
        isNegative(0);
        isNegative(7);

    // Задание 4
        printNTime("Семь раз (seven time)", 7);
        printNTime("Три раза (three time)", 3);
        printNTime("Ноль раз раз (zero time)", 0);

    // Задание 5
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2016));
        System.out.println(isLeapYear(2022));
    }



    // Задание 1
    //  метод, принимающий на вход два целых числа и проверяющий,
    //  что их сумма лежит в пределах от 10 до 20 (включительно),
    //  если да – вернуть true, в противном случае – false.
    private static boolean checkSum(int a, int b) {

        return (a+b >=10 && a+b <= 20);
    }

    // Задание 2
    //метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное
    private static void checkInt(int a) {
        if (a >=0) {
            System.out.println("Положительное (positive)");
        } else {
            System.out.println("Отрицательное (negative)");
        }
    }

    // Задание 3
    // метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное
    private static void isNegative(int a) {
        System.out.println(a < 0);  // 0 считаем положительным числом, как в предыдущем задании
    }

    // Задание 4
    //  метод, которому в качестве аргументов передается строка и число,
    //  метод должен отпечатать в консоль указанную строку, указанное количество раз;
    private static void printNTime(String message, int loops) {
        for (int i = 0; i < loops ; i++) {
            System.out.println(message);
        }
    }

    // Задание 5
    // метод, который определяет, является ли год високосным, и возвращает boolean
    // (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный
    private static boolean isLeapYear(int year) {
        boolean res = false;

        if (year % 4 == 0) {  // каждый четвертый - да
            res = true;
        }

        if (year % 100 ==0) { // каждый сотый - нет
            res = false;
        }

        if (year % 400 == 0) {  // каждый 400-й - да
            res = true;
        }

        return res;
    }



}
