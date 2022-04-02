package br.com.alura.humandev.dtos;

import br.com.alura.humandev.entities.Course;

import java.util.List;

public class CourseDtoApi {

    private String name;
    private String code;
    private int courseTimeHours;
    private String developedSkills;

    public CourseDtoApi(Course course) {
        this.name = course.getName();
        this.code = course.getCode();
        this.courseTimeHours = course.getCourseTimeHours();
        this.developedSkills = course.getDevelopedSkills();
    }

    public static List<CourseDtoApi> toDto(List<Course> courses) {
        return courses.stream().map(CourseDtoApi::new).toList();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getCourseTimeHours() {
        return courseTimeHours;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }
}
