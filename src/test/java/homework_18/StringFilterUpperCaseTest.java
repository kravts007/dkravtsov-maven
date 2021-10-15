package homework_18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringFilterUpperCaseTest {
    @Test
    public void upperCaseAndSortTest() {
        List<String> collection = new ArrayList<>();
        collection.add("ivanna");
        collection.add("Iryna");
        collection.add("iNNa13");
        collection.add("KATYA");
        collection.add("yulia");
        //expected
        List<String> expectedlist = new ArrayList<>();
        expectedlist.add("IVANNA");
        expectedlist.add("IRYNA");
        expectedlist.add("INNA13");
        //actual
        collection = StringFilterUpperCase.upperCaseAndSort(collection);
        Assertions.assertEquals(collection, expectedlist);
    }
}
