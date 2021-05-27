package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

public class SubjectRequest {

    private String name;
    private double grade;

    public SubjectRequest(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
