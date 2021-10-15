package homework_18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AverageFromListOfIntegers {
    public static void main(String[] args) {
        System.out.println(collectionOfIntegers());
        System.out.println(calculateAverageCol(collectionOfIntegers()));
    }


    public static double calculateAverageCol(Collection<Integer> collection) {
        return collection.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    public static Collection<Integer> collectionOfIntegers() {
        List<Integer> list = new ArrayList<>();
        int n = 10;
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            Integer r = rand.nextInt(256);
            list.add(r);
        }
        return list;
    }
}