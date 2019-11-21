package ua.edu.ucu;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private static Student student;
    @BeforeClass
    public static void createNewStudent() {
        student = new Student(
                "Denys", "Maletskyi", 3.8, 2
        );
    }

    @Test
    public void testStudentGetName() {
        String expected = "Denys";
        assertEquals(expected, student.getName());
    }

    @Test
    public void testStudentGetSurname() {
        String expected = "Maletskyi";
        assertEquals(expected, student.getSurname());
    }

    @Test
    public void testStudentGetGPA() {
        double expected = 3.8;
        assertEquals(expected, student.getGPA(), 0.0001);
    }
    @Test
    public void testStudentGetYear() {
        int expected = 2;
        assertEquals(expected, student.getYear());
    }

    @Test
    public void testStudentEquals() {
        Student anotherStudent = new Student(
                "Ivar", "Grimstad", 3.9, 2
        );

        assertNotEquals(student, anotherStudent);
        assertNotEquals(student, "NotAStudentObject");
        assertEquals(student, student);

        Student studentWithTheSameData = new Student(
                "Denys", "Maletskyi", 3.8, 2
        );

        assertEquals(student, studentWithTheSameData);
    }


    @Test
    public void testStudentToString() {
        String expected = "Student{name=Denys, surname=Maletskyi, GPA=3.8, year=2}";
        assertEquals(expected, student.toString());
    }

}
