package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Logger;

public class Classroom {

    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());

    public int maxNumberOfStudents;
    ArrayList<Student> studentArray;


    //iii
    public Classroom() {
        studentArray = new ArrayList<>(30);
    }

    //i
    public Classroom(Integer maxNumberOfStudents) {
        studentArray = new ArrayList<>(maxNumberOfStudents);
    }

    public Classroom(Student[] initialStudents) { //TODO where is this coming from.
        studentArray = new ArrayList<>(initialStudents.length);
        for (int i = 0; i < initialStudents.length; i++)
            studentArray.add(i, initialStudents[i]);
    }

    public Student[] getStudents() {
        Student[] result;
        if (studentArray.size() == 0) {
            result = new Student[0];
        } else {
            result = new Student[studentArray.size()];
            for (int i = 0; i < studentArray.size(); i++) {
                result[i] = studentArray.get(i);
            }
        }
        return result;
    }

    public Double getClassAverageExamScore() {
        Double sum = 0.0;
        for (Student student : studentArray) {
            sum += student.getAverageExamScore();
        }
        return sum / studentArray.size();
    }


    public void addStudent(Student newStudent) {
        studentArray.add(newStudent);
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < studentArray.size(); i++) {
            if ((studentArray.get(i).getFirstName().equals(firstName)) &&
                    (studentArray.get(i).getLastName().equals(lastName))) {
                studentArray.remove(i);
            }
        }
    }
//This method does not work yet. Student cannot be cast to comparable.
// Do I need to tell it a field to compare by? Score then name?
    //Stay tuned...

    public Student[] getStudentByScore() {
        ArrayList<Student> studentByScore = new ArrayList<>();
        Student[] result = new Student[studentArray.size()];
        studentByScore.addAll(studentArray);
        Collections.sort(studentByScore, Collections.reverseOrder());
        for (Integer i = 0; i < studentByScore.size(); i++) {
            result[i] = studentByScore.get(i);
        }
        return result;
    }

    public Map<Student, Character> getGradeBook() {
        Map<Student, Character> grades = new HashMap<>();
        Student[] studentByScore = this.getStudentByScore();
        Integer totalStudents = studentByScore.length;

        Integer cutOffAs = totalStudents / 10;
        Integer cutOffBs = cutOffAs * 3;
        Integer cutOffCs = cutOffAs * 5;
        Integer cutOffDs = cutOffAs * 9;

        for (Integer i = 0; i < cutOffAs; i++) {
            grades.put(studentByScore[i], 'A');
        }
        for (Integer i = cutOffAs; i < cutOffBs; i++) {
            grades.put(studentByScore[i], 'B');
        }
        for (Integer i = cutOffBs; i < cutOffCs; i++) {
            grades.put(studentByScore[i], 'C');
        }
        for (Integer i = cutOffCs; i < cutOffDs; i++) {
            grades.put(studentByScore[i], 'D');
        }
        for (Integer i = cutOffDs; i < totalStudents; i++) {
            grades.put(studentByScore[i], 'F');
        }
        return grades;
    }
}


