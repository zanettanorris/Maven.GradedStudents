package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public ArrayList<Double> getExamScores() {
//        return examScores;
//    }

//    public void setExamScores(ArrayList<Double> examScores) {
//        this.examScores = examScores;
//    }

    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;

    }

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String output = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
            output += "Exam " + (i + 1) + " -> " + Math.round(examScores.get(i));
            if (i != examScores.size() - 1) {
                output += "\n";
            }
        }
        return output;
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore() {
        Double sumOfExamScores = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            sumOfExamScores += examScores.get(i);
        }
        Double averageOfScores = sumOfExamScores / getNumberOfExamsTaken();
        return averageOfScores.doubleValue();
    }

    @Override
    public String toString() {

      return(  "```\n" + "Student Name: " + firstName + " " + lastName + "\n" + "> Average " +
                "Score: " + getAverageExamScore() + "\n" + "> " + getExamScores()+ "\n" + "```");
    }

    //***** Intermission, End of Part 1******
}