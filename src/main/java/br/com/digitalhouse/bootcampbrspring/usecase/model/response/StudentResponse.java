package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import br.com.digitalhouse.bootcampbrspring.usecase.model.request.StudentRequest;

public class StudentResponse {

    private String message;
    private double average;
    private StudentRequest student;

    public StudentResponse() {
    }

    public StudentResponse(String message, double average, StudentRequest student) {
        this.message = message;
        this.average = average;
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StudentRequest getStudent() {
        return student;
    }

    public void setStudent(StudentRequest student) {
        this.student = student;
    }
}
