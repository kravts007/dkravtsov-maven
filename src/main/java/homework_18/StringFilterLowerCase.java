package homework_18;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringFilterLowerCase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Joe", "ben", "ANNA","beach", "JohaNna", "ivan", "PEATY", "curwa", "izzi");
        System.out.println(list);
        System.out.println(lowerCaseAndSort(list));
    }
        public static List<String> lowerCaseAndSort(Collection<String> collection){
            Predicate<String> lowerCase = Pattern
                    .compile("^([a-z]).*")
                    .asPredicate();

            return collection
                    .stream()
                    .filter(lowerCase)
                    .filter(e -> (e.length() == 4))
                    .collect(Collectors.toList());
        }
}
