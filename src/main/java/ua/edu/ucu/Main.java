package ua.edu.ucu;

import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.MapDecorator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BaseArray a = new BaseArray(new Integer[]{1,2,3,4,5});
        System.out.println(Arrays.toString(a.toArray()));

        MapDecorator b = new MapDecorator(a, x->(Integer)x*(Integer)x);

        System.out.println(Arrays.toString(b.toArray()));
        a.setValue(0); // що це працювало додайте метод setValue(int index){array[index] = 0};
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));

        Student student1 = new Student("Ivar", "Grimstad", 3.9, 2);
        Student student2 = new Student("Ivar", "Grimstad", 3.9, 2);
        System.out.println(student1.equals(student2));
    }
}
