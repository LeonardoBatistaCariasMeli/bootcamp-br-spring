package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubjectRequest {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    private Double grade;

    public SubjectRequest(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
