package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;

    public BaseArray(Object[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public Object[] toArray() { return Arrays.copyOf(array, array.length); }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return array.length;
    }
}
