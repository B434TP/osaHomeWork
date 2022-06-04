package lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class PhoneBook {

    private ArrayList<Person> book = new ArrayList<>();
    private HashMap<UUID, String> namesDic = new HashMap<>();

    private class Person {
        private UUID nameId;
        private String phone;

        public Person(String name, String phone) {
            this.nameId = getNameId(name);
            this.phone = phone;
        }

        private UUID getNameId(String name) {
            UUID newPersonId = null;

            if (namesDic.containsValue(name)) {
                for (UUID key : namesDic.keySet()) {
                    if (namesDic.get(key) == name) {
                        newPersonId = key;
                    }
                }
            } else {
                newPersonId = UUID.randomUUID();
                namesDic.put(newPersonId, name);
            }
            return newPersonId;
        }

        public String getName() {
            return namesDic.get(this.nameId);
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return "<" + nameId + "> " + " - " + phone;
        }
    }


    public void add(String name, String phone) {
        book.add(new Person(name, phone));
        System.out.println("+ 1 record: <" + name + "> # " + phone);
    }

    public void get(String name) {

        System.out.println("\n Search results for: " + name);
        book.stream()
                .filter(person -> Objects.equals(person.getName(), name))
                .map(Person::getPhone)
                .forEach(System.out::println);
    }

    public void showData() {
        System.out.println("Phonebook data: " + book);

        System.out.println("Names dictionary data: " + namesDic);
    }


}


