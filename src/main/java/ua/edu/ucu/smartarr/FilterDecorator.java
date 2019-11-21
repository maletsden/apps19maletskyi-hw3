package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private Object[] array;
    private MyPredicate myPr;

    public FilterDecorator(SmartArray array, MyPredicate pr) {
        super(array);
        myPr = pr;
    }

    @Override
    public Object[] toArray() {
        if (array == null) {
            Stream<Object> arraySteam = Arrays.stream(smartArray.toArray());
            array = arraySteam.filter(
                    obj -> myPr.test(obj)
            ).toArray(Object[]::new);
        }
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + filterDecorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
