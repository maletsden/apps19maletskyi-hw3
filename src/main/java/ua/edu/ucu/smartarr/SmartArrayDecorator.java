package ua.edu.ucu.smartarr;

import java.util.Arrays;

abstract class SmartArrayDecorator implements SmartArray {
    protected boolean isArrayChanged;
    protected Object[] decoratedArray;

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public void setIsArrayChanged(boolean arrayChanged) {
        isArrayChanged = arrayChanged;
    }

    protected abstract Object[] applyChanges(Object[] array);

    @Override
    public Object[] toArray() {
        Object[] baseArray = smartArray.toArray(this);

        if (isArrayChanged) {
            decoratedArray = applyChanges(baseArray);
        }

        return Arrays.copyOf(decoratedArray, decoratedArray.length);
    }

    @Override
    public Object[] toArray(SmartArrayDecorator decorator) {
        Object[] baseArray = smartArray.toArray(this);

        if (isArrayChanged) {
            Object[] changedArray = applyChanges(baseArray);
            if (Arrays.deepEquals(decoratedArray, changedArray)) {
                decorator.setIsArrayChanged(false);
                return null;
            } else {
                decorator.setIsArrayChanged(true);
                decoratedArray = changedArray;
                return decoratedArray;
            }
        } else {
            decorator.setIsArrayChanged(false);
            return null;
        }
    }

    @Override
    public int size() {
        Object[] baseArray = smartArray.toArray(this);

        if (isArrayChanged) {
            decoratedArray = applyChanges(baseArray);
        }

        return decoratedArray.length;
    }
}
