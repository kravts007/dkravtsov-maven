package homework_18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringFilterLowerCaseTest {

    @Test
    public void lowerCaseAndSortTest() {
        List<String> collection = new ArrayList<>();
        collection.add("joah");
        collection.add("BENNY");
        collection.add("squirrel");
        collection.add("nOOb");
        collection.add("brage");
        collection.add("win");
        //expected
        List<String> expectedList = new ArrayList<>();
        expectedList.add("joah");
        expectedList.add("nOOb");
        //actual
        collection = StringFilterLowerCase.lowerCaseAndSort(collection);
        Assertions.assertEquals(expectedList, collection);
    }

}
