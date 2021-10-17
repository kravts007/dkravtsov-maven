package homework_18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AverageFromListOfIntegersTest {
    @Test
    public void calculateAverageColTest() {
        List<Integer> collection = new ArrayList<>();
        int colSize = 5;
        //expected
        double expectedAverage = 0.0;
        for (int i = 0; i < colSize; i++) {
            collection.add(i);
            expectedAverage += i;
        }
        expectedAverage /= colSize;
        //actual
        double actualAverage = AverageFromListOfIntegers.calculateAverageCol(collection);
        Assertions.assertEquals(expectedAverage, actualAverage);
    }
}