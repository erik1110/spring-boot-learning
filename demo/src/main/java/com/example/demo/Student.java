package com.example.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Student {

    @NotBlank
    private String name;

    @Min(100)
    @NotNull
    private Integer id;

    @NotEmpty
    private List<String> course_list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getCourse_list() {
        return course_list;
    }

    public void setCourse_list(List<String> course_list) {
        this.course_list = course_list;
    }
}
