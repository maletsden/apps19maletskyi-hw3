package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.stream.Stream;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private Object[] array;

    public DistinctDecorator(SmartArray array) {
        super(array);
    }

    @Override
    public Object[] toArray() {
        if (array == null) {
            Stream<Object> arraySteam = Arrays.stream(smartArray.toArray());
            array = arraySteam.distinct().toArray(Object[]::new);
        }

        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + distinctDecorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
