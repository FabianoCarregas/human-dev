package br.com.alura.humandev.dtos.publicLink;

import br.com.alura.humandev.entities.Course;

public class CourseLinkDto {

    private String name;
    private Integer courseTimeHours;

    public CourseLinkDto(Course course) {
        this.name = course.getName();
        this.courseTimeHours = course.getCourseTimeHours();
    }

    public String getName() {
        return name;
    }

    public Integer getCourseTimeHours() {
        return courseTimeHours;
    }

}

