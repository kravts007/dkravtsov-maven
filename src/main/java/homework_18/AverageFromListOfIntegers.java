package homework_18;

import java.util.Arrays;
import java.util.List;

public class AverageFromListOfIntegers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(list);

        double average = list
                .stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
        System.out.println(average);
    }
}
//    public static double calculateAverageCol(Collection<Integer> collection) {
//        return collection.stream()
//                .mapToDouble(d -> d)
//                .average()
//                .orElse(0.0);
//    }
//
//    public static Collection<Integer> collectionOfIntegers() {
//        List<Integer> list = new ArrayList<>();
//        int n = 5;
//        Random rand = new Random();
//        rand.setSeed(System.currentTimeMillis());
//        for (int i = 0; i < n; i++) {
//            Integer r = rand.nextInt(256);
//            list.add(r);
//        }
//        return list;
//    }