package lesson05;

public class Main {
    public static void main(String[] args) {

        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan Ivanovich","Manager", "ivanov@mail.ru", "654654654", 100000,30);
        persArray[1] = new Person("Petrov Boris Ivanovich","Administrator", "petrov@mail.ru", "653453454654", 80000,25);
        persArray[2] = new Person("Sidorov Nikolay Ivanovich","Administrator", "ded@mail.ru", "6532347689", 180000,78);
        persArray[3] = new Person("Kotov Boris Ivanovich","Administrator", "ok@mail.ru", "6535462253", 1080000,40);
        persArray[4] = new Person("Frolova Ivanka ","Administrator", "rybka@mail.ru", "65342435464", 70000,45);


        for (Person person: persArray) {
            if (person.getAge() > 40) {
                person.printInfo();
            }
        }
    }
}
