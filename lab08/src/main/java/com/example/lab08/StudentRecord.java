package com.example.lab08;

public class StudentRecord {

    private String studentID;
    private Float midterm;
    private Float assignments;
    private Float finalExam;
    private Double finalMark;
    private String letterGrade;

    public StudentRecord(String studentID, float midterm, float assigments,
                         float finalExam) {

        this.studentID = studentID;
        this.midterm = midterm;
        this.assignments = assigments;
        this.finalExam = finalExam;
        this.finalMark = calculateFinalMark();
        this.letterGrade = calculateLetterGrade();
    }

    private Double calculateFinalMark() {
        return (this.midterm*0.3 + this.assignments *0.2 + this.finalExam*0.5);
    }

    private String calculateLetterGrade() {
        String letterGrade = null;
        if (this.finalMark>=80.0 && this.finalMark<=100.0) {
            letterGrade = "A";
        }
        else if (this.finalMark>=70.0 && this.finalMark<80.0) {
            letterGrade = "B";
        }
        else if (this.finalMark>=60.0 && this.finalMark<70.0) {
            letterGrade = "C";
        }
        else if (this.finalMark>=50.0 && this.finalMark<60.0) {
            letterGrade = "D";
        }
        else if (this.finalMark>=0.0 && this.finalMark<50.0) {
            letterGrade = "F";
        }

        return letterGrade;
    }

    public String getStudentID() {
        return studentID;
    }

    public Float getMidterm() {
        return midterm;
    }

    public Float getAssignments() {
        return assignments;
    }

    public Float getFinalExam() {
        return finalExam;
    }

    public Double getFinalMark() {
        return finalMark;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

}
