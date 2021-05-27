package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import br.com.digitalhouse.bootcampbrspring.usecase.model.request.StudentRequest;

public class StudentResponse {

    private String name;
    private String message;
    private double gradeAverage;

    public StudentResponse() {
    }

    public StudentResponse(String name, String message, double gradeAverage) {
        this.name = name;
        this.message = message;
        this.gradeAverage = gradeAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(double gradeAverage) {
        this.gradeAverage = gradeAverage;
    }
}
