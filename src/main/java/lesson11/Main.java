package lesson11;

public class Main {
    public static void main(String[] args) {

       doubleSearcherTest();
       System.out.println("\n______________________________________________\n");
       phoneBookTest();


    }


    private static void doubleSearcherTest() {

        String[] myArray = new String[15];

        myArray[0] = "one";
        myArray[1] = "two";
        myArray[2] = "three";
        myArray[3] = "four";
        myArray[4] = "four";
        myArray[5] = "five";
        myArray[6] = "six";
        myArray[7] = "five";
        myArray[8] = "four";
        myArray[9] = "seven";
        myArray[10] = "four";
        myArray[11] = "eleven";
        myArray[12] = "twelve";
        myArray[13] = "nine";
        myArray[14] = "nine";


        DoubleSearcher ds = new DoubleSearcher();
        ds.setData(myArray);
        ds.showData();
        ds.findUnique();
        ds.countUnique();

    }

    private static void phoneBookTest() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Tom", "+711111111111");
        phoneBook.add("911", "911");
        phoneBook.add("Tom", "+722222222222");
        phoneBook.add("Tom", "+733333333333");
        phoneBook.add("Sergey", "+79035870622");
        phoneBook.add("Oksana", "+19512121212622");

        phoneBook.showData();

        phoneBook.get("Tom");
        phoneBook.get("Oksana");
        phoneBook.get("test");
    }

}
