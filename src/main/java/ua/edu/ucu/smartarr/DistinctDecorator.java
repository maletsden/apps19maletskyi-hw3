package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray array) {
        super(array);
        decoratedArray = applyChanges(smartArray.toArray());
    }

    @Override
    protected Object[] applyChanges(Object[] array) {
        Stream<Object> arraySteam = Arrays.stream(array);

        return arraySteam.distinct().toArray(Object[]::new);
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + distinctDecorator";
    }
}
