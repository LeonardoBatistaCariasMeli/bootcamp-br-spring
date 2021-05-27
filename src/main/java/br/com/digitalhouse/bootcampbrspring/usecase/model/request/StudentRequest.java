package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

import java.util.List;

public class StudentRequest {

    private String name;
    private List<SubjectRequest> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectRequest> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectRequest> subjects) {
        this.subjects = subjects;
    }
}