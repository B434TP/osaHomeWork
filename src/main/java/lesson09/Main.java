package lesson09;

public class Main {
    public static void main(String[] args) {

//        String[][] myArray = new String[3][4];
        String[][] myArray = new String[4][4];

        fillArray(myArray);

        myArray[2][2] = "!";

        printArray(myArray);


        int arraySum = 0;

        try {
            arraySum =  sumArrayItems(myArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.exit(1);
        }


        System.out.println(arraySum);
    }

    private static int sumArrayItems(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (array.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {

            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }

    private static void printArray(String[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    private static void fillArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.toString(i + j);
            }
        }
    }
}
