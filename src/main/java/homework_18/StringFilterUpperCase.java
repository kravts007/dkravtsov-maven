package homework_18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringFilterUpperCase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Joe", "ben", "anna", "Johanna", "Ivan");
        System.out.println(list);

        Predicate<String> vowelLetter = Pattern
                .compile("^(?i:[aeiouy]).*")
                .asPredicate();
        List<String> sortUppercase = list
                .stream()
                .filter(vowelLetter)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(sortUppercase);
    }
}
