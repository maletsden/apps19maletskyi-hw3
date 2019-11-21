package ua.edu.ucu.smartarr;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SmartArrayTest {
    private static SmartArray smartArray;

    @BeforeClass
    public static void createSmartArray() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3, 1};

        smartArray = new BaseArray(integers);
    }

    @Test
    public void testBaseArray() {
        String expectedRes = "BaseArray";

        assertEquals(expectedRes, smartArray.operationDescription());

        int expectedSize = 7;
        assertEquals(expectedSize, smartArray.size());
    }

    @Test
    public void testDistinctDecorator() {
        SmartArray distinctSmartArray = new DistinctDecorator(
                smartArray
        );

        String expectedRes = "BaseArray + distinctDecorator";

        assertEquals(expectedRes, distinctSmartArray.operationDescription());

        int expectedSize = 6;
        assertEquals(expectedSize, distinctSmartArray.size());

        Integer[] expectedArray = {-1, 2, 0, 1, -5, 3};
        assertArrayEquals(expectedArray, distinctSmartArray.toArray());
    }

    @Test
    public void testFilterDecorator() {
        MyPredicate pr = new MyPredicate() {
            public boolean test(Object t) {
                return (Integer)t > 0;
            }
        };

        SmartArray filteredSmartArray = new FilterDecorator(
                smartArray,
                pr
        );

        String expectedRes = "BaseArray + filterDecorator";

        assertEquals(expectedRes, filteredSmartArray.operationDescription());

        int expectedSize = 4;
        assertEquals(expectedSize, filteredSmartArray.size());

        Integer[] expectedArray = {2, 1, 3, 1};
        assertArrayEquals(expectedArray, filteredSmartArray.toArray());
    }

    @Test
    public void testMapDecorator() {
        MyFunction func = new MyFunction() {
            public Object apply(Object t) {
                return -1 * (Integer)t;
            }
        };
        SmartArray filteredSmartArray = new MapDecorator(
                smartArray,
                func
        );

        String expectedRes = "BaseArray + mapDecorator";

        assertEquals(expectedRes, filteredSmartArray.operationDescription());

        int expectedSize = 7;
        assertEquals(expectedSize, filteredSmartArray.size());

        Integer[] expectedArray = {1, -2, -0, -1, 5, -3, -1};
        assertArrayEquals(expectedArray, filteredSmartArray.toArray());
    }

    @Test
    public void testSortDecorator() {
        MyComparator cmp = new MyComparator() {
            public int compare(Object o1, Object o2) {
                return (Integer)o1 - (Integer)o2;
            }
        };

        SmartArray filteredSmartArray = new SortDecorator(
                smartArray,
                cmp
        );

        String expectedRes = "BaseArray + sortDecorator";

        assertEquals(expectedRes, filteredSmartArray.operationDescription());

        int expectedSize = 7;
        assertEquals(expectedSize, filteredSmartArray.size());

        Integer[] expectedArray = {-5, -1, 0, 1, 1, 2, 3};
        assertArrayEquals(expectedArray, filteredSmartArray.toArray());
    }

}
