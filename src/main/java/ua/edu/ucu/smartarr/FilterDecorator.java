package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate myPr;

    public FilterDecorator(SmartArray array, MyPredicate pr) {
        super(array);
        myPr = pr;
        decoratedArray = applyChanges(smartArray.toArray());
    }

    @Override
    protected Object[] applyChanges(Object[] array) {
        Stream<Object> arraySteam = Arrays.stream(array);

        return arraySteam.filter(myPr::test).toArray(Object[]::new);
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + filterDecorator";
    }
}
