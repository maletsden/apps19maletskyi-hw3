package ua.edu.ucu.smartarr;

public interface SmartArray {

    Object[] toArray(); // return array with SmartArray elements

    Object[] toArray(SmartArrayDecorator decorator);

    String operationDescription(); // return current operation name applied to SmartArray
    
    int size(); // return SmartArray size
   
}
