
package com.mycompany.mainapp;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;



public class MainappTest {

    private ArrayList<Student> students;

    @Before
    public void setUp() {
        students = new ArrayList<>();
    }

    @Test
    public void testCaptureStudent() {
        Student student = new Student(1, "John", "Doe", 20);
        students.add(student);

        assertEquals(1, students.size());
        assertEquals("John", students.get(0).getFirstName());
        assertEquals("Doe", students.get(0).getLastName());
        assertEquals(20, students.get(0).getAge());
    }

    @Test
    public void testSearchStudent() {
        Student student = new Student(1, "John", "Doe", 20);
        students.add(student);

        Student foundStudent = Mainapp.searchStudent(1, students);

        assertNotNull(foundStudent);
        assertEquals("John", foundStudent.getFirstName());
        assertEquals("Doe", foundStudent.getLastName());
        assertEquals(20, foundStudent.getAge());
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student(1, "John", "Doe", 20);
        students.add(student);

        boolean deleted = Mainapp.deleteStudent(1, students);

        assertTrue(deleted);
        assertEquals(0, students.size());
    }

    @Test
    public void testDeleteStudentNotFound() {
        Student student = new Student(1, "John", "Doe", 20);
        students.add(student);

        boolean deleted = Mainapp.deleteStudent(2, students);

        assertFalse(deleted);
        assertEquals(1, students.size());
    }

    @Test
    public void testPrintStudentReport() {
        Student student1 = new Student(1, "John", "Doe", 20);
        Student student2 = new Student(2, "Alice", "Smith", 22);
        students.add(student1);
        students.add(student2);

        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Mainapp.printStudentReport();

        
        String expectedOutput = "Student Report:\n" +
                "Student ID: 1\n" +
                "Name: John Doe\n" +
                "Age: 20\n\n" +
                "Student ID: 2\n" +
                "Name: Alice Smith\n" +
                "Age: 22\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}

