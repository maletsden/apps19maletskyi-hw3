package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private MyPredicate pr;

    public DistinctDecorator(SmartArray array) {
        super(array);
    }

    @Override
    public Object[] toArray() {
        Stream<Object> arraySteam = Arrays.stream(smartArray.toArray());
        return arraySteam.distinct().toArray(Object[]::new);
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
