package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClassroomTest {

    Double[] s1Scores = {100.0, 100.0};
    Double[] s2Scores = {125.0, 75.0};
    Double[] s3Scores = {80.0, 120.0};
    Double[] s4Scores = {90.0, 110.0};

    Double[] s5Scores = {100.0, 100.0}; //A
    Double[] s6Scores = {89.0, 89.0}; //B
    Double[] s7Scores = {85.0, 85.0}; //B
    Double[] s8Scores = {70.0, 70.0}; //C
    Double[] s9Scores = {65.0, 65.0}; //C
    Double[] s10Scores = {55.0, 55.0}; //D
    Double[] s11Scores = {45.0, 45.0}; //D
    Double[] s12Scores = {40.0, 50.0}; //D
    Double[] s13Scores = {40.0, 40.0}; //D
    Double[] s14Scores = {25.0, 25.0}; //F


    Student s1 = new Student("student", "one", s1Scores);
    Student s2 = new Student("student", "two", s2Scores);
    Student s3 = new Student("student", "three", s3Scores);
    Student s4 = new Student("student", "four", s4Scores);

    Student s5 = new Student("student", "five", s5Scores);
    Student s6 = new Student("student", "six", s6Scores);
    Student s7 = new Student("student", "seven", s7Scores);
    Student s8 = new Student("student", "eight", s8Scores);
    Student s9 = new Student("student", "nine", s9Scores);
    Student s10 = new Student("student", "ten", s10Scores);
    Student s11 = new Student("student", "eleven", s11Scores);
    Student s12 = new Student("student", "twelve", s12Scores);
    Student s13 = new Student("student", "thirteen", s13Scores);
    Student s14 = new Student("student", "fourteen", s14Scores);
    Student[] testStudents = {s1, s2, s3};
    Student[] addStudentTestArray = {s1, s2, s3, s4};
    Student[] gradeBookTestArraySorted = {s5, s6, s7, s8, s9, s10, s11, s12, s13, s14};
    Student[] gradeBookTestArrayUnsorted = {s5, s13, s7, s10, s8, s11, s9, s12, s14, s6};


    Classroom testClass;


    @Test
    public void getStudentsTest() {
        Student[] expected = testStudents;
        testClass = new Classroom(testStudents);

        Student[] actual = testClass.getStudents();

        Assert.assertArrayEquals(actual, expected);

    }

    @Test
    public void GetClassAverageExamScoreTest() {
        testClass = new Classroom(testStudents);
        Double actual = 125.0;
        Double expected = testClass.getClassAverageExamScore();
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void addStudentTest() {
        Student[] expected = addStudentTestArray;
        testClass = new Classroom(testStudents);
        testClass.addStudent(s4);
        Student[] actual = testClass.getStudents();
        Assert.assertArrayEquals(actual, expected);

    }

    //This method does not work yet. Student cannot be cast to comparable.
// Do I need to give it a field to compare by? Score then name?
    @Test
    public void getStudentByScoreTest() {
        testClass = new Classroom(gradeBookTestArrayUnsorted);
        Student[] actual = testClass.getStudentByScore();
        Student[] expected = gradeBookTestArraySorted;
        Assert.assertArrayEquals(actual, expected);
    }
}
