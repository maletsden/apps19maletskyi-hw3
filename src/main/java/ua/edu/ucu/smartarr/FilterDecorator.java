package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate pr;

    public FilterDecorator(SmartArray array, MyPredicate pr) {
        super(array);
        this.pr = pr;
    }

    @Override
    public Object[] toArray() {
        Stream<Object> arraySteam = Arrays.stream(smartArray.toArray());
        return arraySteam.filter(obj -> pr.test(obj)).toArray(Object[]::new);
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
