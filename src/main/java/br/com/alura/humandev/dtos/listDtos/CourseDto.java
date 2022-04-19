package br.com.alura.humandev.dtos.listDtos;

import br.com.alura.humandev.entities.Course;

public class CourseDto {

    private Long id;
    private String name;
    private String code;
    private boolean active;

    @Deprecated
    public CourseDto() {
    }

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.active = course.isActive();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
