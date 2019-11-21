package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private Object[] array;
    private MyComparator myCmp;

    public SortDecorator(SmartArray array, MyComparator cmp) {
        super(array);
        myCmp = cmp;
    }

    @Override
    public Object[] toArray() {
        if (array == null) {
            array = smartArray.toArray();
            Arrays.sort(array, myCmp);
        }
        return Arrays.copyOf(array, array.length);
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
