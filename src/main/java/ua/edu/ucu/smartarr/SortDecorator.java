package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;
import java.util.stream.Stream;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator cmp;

    public SortDecorator(SmartArray array, MyComparator cmp) {
        super(array);
        this.cmp = cmp;
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        Arrays.sort(array, cmp);
        return array;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + sortDecorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
