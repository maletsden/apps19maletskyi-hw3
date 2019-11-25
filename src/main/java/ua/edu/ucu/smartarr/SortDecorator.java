package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator myCmp;

    public SortDecorator(SmartArray array, MyComparator cmp) {
        super(array);
        myCmp = cmp;
        decoratedArray = applyChanges(smartArray.toArray());

    }

    @Override
    protected Object[] applyChanges(Object[] array) {
        Arrays.sort(array, myCmp);
        return array;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " + sortDecorator";
    }
}
