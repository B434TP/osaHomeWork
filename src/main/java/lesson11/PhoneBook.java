package lesson11;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneBook {

    private class Person {
        private String name;
        private String phone;

        public Person(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return name + " - " + phone;
        }
    }

    private ArrayList<Person> book = new ArrayList<>();


    public void add(String name, String phone) {
        book.add(new Person(name,phone));
        System.out.println("+ 1 record: <"+ name + "> # " + phone);
    }

    public void findByName(String name){

        System.out.println("\n Search results for: " + name);
        book.stream()
                .filter(person -> Objects.equals(person.getName(), name))
                .map(Person::getPhone)
                .forEach(System.out::println);
    }

    public void showData(){
        System.out.println("All data: " + book);
    }

}


