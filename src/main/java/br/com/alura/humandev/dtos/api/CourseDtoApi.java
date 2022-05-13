package br.com.alura.humandev.dtos.api;

import br.com.alura.humandev.entities.Course;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
