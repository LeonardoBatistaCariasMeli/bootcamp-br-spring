package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentRequest {

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @Valid
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