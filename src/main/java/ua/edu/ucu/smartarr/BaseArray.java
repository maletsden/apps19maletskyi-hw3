package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] originArray;
    private Object[] baseArray;

    public BaseArray(Object[] array) {
        originArray = array;
        baseArray = toArray();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(originArray, originArray.length);
    }

    @Override
    public Object[] toArray(SmartArrayDecorator decorator) {
        boolean equal = Arrays.deepEquals(originArray, baseArray);
        decorator.setIsArrayChanged(!equal);
        if (equal) {
            return null;
        }

        baseArray = toArray();
        return baseArray;
    }

    public void setValue(int index){
        originArray[index] = 0;
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return originArray.length;
    }
}
