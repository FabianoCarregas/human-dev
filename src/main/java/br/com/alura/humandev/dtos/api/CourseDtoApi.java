package br.com.alura.humandev.dtos.api;

import br.com.alura.humandev.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
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

}
