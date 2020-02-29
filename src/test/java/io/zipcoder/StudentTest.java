package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

   String firstName;
   String lastName;
   ArrayList<Double> examScores;
   Student student;

   @Before
   public void init() {
       firstName = "Jimmy";
       lastName = "Choo";
       examScores = new ArrayList<>(Arrays.asList(100.0, 90.0, 95.0, 85.0));
       student = new Student(firstName, lastName, examScores);
   }

    @Test
    public void Student1Test(){
        Assert.assertEquals("Jimmy", student.getFirstName());
        Assert.assertEquals("Choo", student.getLastName());
    }

    @Test
    public void getExamScoresTest(){
       String expected = "Exam Scores:\n" +
               "Exam 1 -> 100\n" +
               "Exam 2 -> 90\n" +
               "Exam 3 -> 95\n" +
               "Exam 4 -> 85";
       String actual = student.getExamScores();
       Assert.assertEquals(expected, actual);
    }



}