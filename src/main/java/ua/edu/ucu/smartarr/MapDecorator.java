package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;
import java.util.stream.Stream;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private Object[] array;
    private MyFunction myFn;

    public MapDecorator(SmartArray array, MyFunction fn) {
        super(array);
        myFn = fn;
    }

    @Override
    public Object[] toArray() {
        if (array == null) {
            Stream<Object> arraySteam = Arrays.stream(smartArray.toArray());
            array = arraySteam.map(
                    obj -> myFn.apply(obj)
            ).toArray(Object[]::new);
        }
        return Arrays.copyOf(array, array.length);
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
