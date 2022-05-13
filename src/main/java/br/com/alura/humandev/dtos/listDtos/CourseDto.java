package br.com.alura.humandev.dtos.listDtos;

import br.com.alura.humandev.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
