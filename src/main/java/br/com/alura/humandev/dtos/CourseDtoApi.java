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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCourseTimeHours(int courseTimeHours) {
        this.courseTimeHours = courseTimeHours;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }
}
