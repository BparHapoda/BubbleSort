import org.example.MyLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.example.Main.bubbleSort;


public class BubbleSortTest {
    @Test
    void testFun() {
        ArrayList<Integer> testList = new ArrayList<>();
        MyLogger myLogger = new MyLogger();
        testList.add(3);
        testList.add(2);
        testList.add(1);
        ArrayList<Integer> actual = bubbleSort(testList, myLogger);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        Assertions.assertEquals(expected, actual);
    }


}
