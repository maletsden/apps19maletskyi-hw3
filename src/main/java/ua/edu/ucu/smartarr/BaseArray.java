package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] baseArray;

    public BaseArray(Object[] array) {
        baseArray = Arrays.copyOf(array, array.length);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(baseArray, baseArray.length);
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return baseArray.length;
    }
}
