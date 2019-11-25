package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;
import java.util.stream.Stream;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction myFn;

    public MapDecorator(SmartArray array, MyFunction fn) {
        super(array);
        myFn = fn;
        decoratedArray = applyChanges(smartArray.toArray());
    }

    @Override
    protected Object[] applyChanges(Object[] array) {
        Stream<Object> arraySteam = Arrays.stream(array);

        return arraySteam.map(myFn::apply).toArray(Object[]::new);
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + mapDecorator";
    }
}
