package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction fn;

    public MapDecorator(SmartArray array, MyFunction fn) {
        super(array);
        this.fn = fn;
    }

    @Override
    public Object[] toArray() {
        Stream<Object> arraySteam = Arrays.stream(smartArray.toArray());
        return arraySteam.map((obj) -> fn.apply(obj)).toArray(Object[]::new);
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + mapDecorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
