package homework_18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AverageFromListOfIntegersTest {
    static List<Integer> integers = new ArrayList<>();

    @Test
    public void calculateAverageColTest() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            Integer r = rand.nextInt(256);
            integers.add(r);
        }
        Assertions.assertEquals(
                //expected
                integers.stream()
                        .mapToDouble(Integer::doubleValue)
                        .sum()
                        /integers.size(),
                //actual
                AverageFromListOfIntegers.calculateAverageCol(integers),
                0.01);
    }
}