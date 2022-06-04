package lesson11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class DoubleSearcher {
    private ArrayList<String> data = new ArrayList<>();

    public void setData(String[] arrayToAdd) {
        Collections.addAll(data, arrayToAdd);
    }

    public void findUnique() {
        System.out.println("Unique items: " + data.stream().distinct().toList());
    }

    public void countUnique() {
        for (int i = 0; i < data.stream().distinct().count(); i++) {
            String item = data.stream()
                    .distinct()
                    .toList()
                    .get(i);
            long count = data.stream()
                    .filter(item::equals)
                    .count();
            System.out.printf("Word: '%s' -  count: %s \n", item, count);
        }
    }

    public void showData() {
        System.out.println("All data:" + data);
    }
}
