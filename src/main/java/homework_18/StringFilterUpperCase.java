package homework_18;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 3 - Имеется коллекция из String, отфильтровать и вывести на экран все значения, которые написаны в loverCase and length = 4
 */

public class StringFilterUpperCase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Joe", "ben", "anna", "Johanna", "Ivan", "eVA!2");
        System.out.println(list);
        System.out.println(upperCaseAndSort(list));
    }
    public static List<String> upperCaseAndSort(Collection<String> collection){
        Predicate<String> vowelLetter = Pattern
                .compile("^(?i:[aeiou]).*")
                .asPredicate();
        return collection
                .stream()
                .filter(vowelLetter)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
