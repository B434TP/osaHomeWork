package lesson03;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        // Задание 1
        System.out.println("---- #1 ----");
        otherwiseChange();

        // Задание 2
        System.out.println("\n---- #2 ----");
        fillBigArray();

        // Задание 3
        System.out.println("\n---- #3 ----");
        int[] arrayToDouble = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayToDouble));
        arrayToDouble = doubleNumbers(arrayToDouble , 6);
        System.out.println(Arrays.toString(arrayToDouble));

        // Задание 4
        System.out.println("\n---- #4 ----");
        fillDiagonals(7);

        // Задание 5
        System.out.println("\n---- #5 ----");
        System.out.println(Arrays.toString(fillMyArray(6, 17)));

        // Задание 6
        System.out.println("\n---- #6 ----");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        findMinMax(arr);

        // Задание 7
        System.out.println("\n---- #7 ----");
        System.out.println(hasEqualParts(arr));

        int[] arr2 = {1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 3, 2};
        System.out.println(hasEqualParts(arr2));

        // Задание 8
        System.out.println("\n---- #8 ----");
        int[] arr3 = {1,0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(arr3));
        shiftItems(arr3, 2);            // пример сдвига вправо
        System.out.println(Arrays.toString(arr3));
        shiftItems(arr3, -2);           // пример сдвига влево
        System.out.println(Arrays.toString(arr3));
    }


    // Задание 1
    private static void otherwiseChange() {
        int[] myFirstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(myFirstArray));

        for (int i = 0; i < myFirstArray.length; i++) {
            myFirstArray[i] = (myFirstArray[i] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(myFirstArray));
    }

    // Задание 2
    private static void fillBigArray() {
        int[] bigArray = new int[100];

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = i+1;
        }

        System.out.println(Arrays.toString(bigArray));
    }

    // Задание 3
    private static int[] doubleNumbers(int[] array, int bound) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < bound) {
                array[i] = array[i] * 2;
            }
        }
        return array;
    }

    // Задание 4
    private static void fillDiagonals(int arraySize) {
    int[][] arrayToFill = new int[arraySize][arraySize];

        for (int i = 0; i < arrayToFill.length; i++) {
            int[] itemsLine = arrayToFill[i];
            for (int j = 0; j < itemsLine.length; j++) {
                if (i == j) {
                    arrayToFill[i][j] = 1;
                }
                if (i + j == arraySize-1) {
                    arrayToFill[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < arrayToFill.length; i++) {
            System.out.println(Arrays.toString(arrayToFill[i]));
        }
    }

    // Задание 5
    private static int[] fillMyArray(int len, int initialValue ) {
        int[] myArray = new int[len];
        Arrays.fill(myArray, initialValue);
        return myArray;
    }

    // Задание 6
    private static void findMinMax(int[] arr) {
        int[] arrToSort = arr;  // новый архив, для того чтобы сортировка не затронула исходный
        System.out.println(Arrays.toString(arrToSort));

        Arrays.sort(arrToSort);
        int min = arrToSort[0];
        int max = arrToSort[arrToSort.length-1];

        System.out.println("min = " + min + " max = " + max);
    }

    // Задание 7
    private static boolean hasEqualParts(int[] arr) {
        int s1 = 0;   // сумма сравнения 1
        int s2;     // сумма сравнения 2

        for (int i = 0; i < arr.length; i++) {
            s1 +=  arr[i]; // первая сумма увеличивается на следующий итем
            s2 = 0;       // обнуляем вторую сумму, она каждый раз считается с другой позиции
            for (int j = i+1; j < arr.length; j++) {   // сумма 2 считается итем +1 от первой и до конца
                s2 += arr[j];
            }
            if (s1 == s2) {
                return true;
            }
        }
        return false;
    }


    // Задание 8
    private static void shiftItems(int[] arr, int shiftSize) {

        for (int i = 0; i < Math.abs(shiftSize); i++) {  // двигать будем n раз, вне зависимости от направления
            if (shiftSize >= 0) {
                directShiftItemsOneTime(arr);
            } else {
                reversShiftItemsOneTime(arr);
            }
        }

    }

    // сдвиг элементов массива на 1 в прямом направлении
    private static void directShiftItemsOneTime(int[] arr) {
            int last =  arr[arr.length-1];  // сохраняем последний элемент

            for (int i = arr.length-1; i > 0; i--) {   // обход от последнего к первому
                arr[i] = arr[i-1];          // сдвигаем
            }
            arr[0] = last;  // последний становится первым
    }

    // сдвиг элементов массива на 1 в обратном направлении
    private static void reversShiftItemsOneTime(int[] arr) {
        int first =  arr[0];  // сохраняем первый элемент

        for (int i = 0; i < arr.length-1; i++) {   // обход от первого к предпоследнему
            arr[i] = arr[i+1];          // сдвигаем
        }
        arr[arr.length-1] = first;  // первый становится последним
    }
}
