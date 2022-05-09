package br.com.alura.humandev.dtos.listDtos;

import br.com.alura.humandev.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseDto {

    private Long id;
    private String name;
    private String code;
    private boolean active;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.active = course.isActive();
    }

}
