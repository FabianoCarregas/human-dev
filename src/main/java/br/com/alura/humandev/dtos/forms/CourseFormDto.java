package br.com.alura.humandev.dtos.forms;

import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseFormDto {

    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;

    @Min(1)
    @Max(value = 20, message = "{number.max}")
    @Positive(message = "{number.invalid}")
    private Integer courseTimeHours;
    private boolean active;
    private String targetAudience;

    @NotBlank(message = "{name.invalid}")
    private String instructor;
    private String courseDescription;
    private String developedSkills;
    private Long subcategoryId;

    public CourseFormDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.courseTimeHours = course.getCourseTimeHours();
        this.active = course.isActive();
        this.targetAudience = course.getTargetAudience();
        this.instructor = course.getInstructor();
        this.courseDescription = course.getCourseDescription();
        this.developedSkills = course.getDevelopedSkills();
    }

    public Course toEntity(Subcategory subcategory) {
        return new Course(id, name, courseTimeHours, code, active, targetAudience, instructor, courseDescription, developedSkills, subcategory);
    }

}
