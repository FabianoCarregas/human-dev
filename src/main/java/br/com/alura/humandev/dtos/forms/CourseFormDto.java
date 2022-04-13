package br.com.alura.humandev.dtos.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CourseFormDto {

    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;
    private String courseDescription;
    private boolean active;
    private String targetAudience;
    private String developedSkills;
    private Long subcategoryId;

    @Deprecated
    public CourseFormDto() {
    }

    public CourseFormDto(Long id,
                         String name,
                         String code,
                         String courseDescription,
                         boolean active,
                         String targetAudience,
                         String developedSkills,
                         Long subcategoryId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.courseDescription = courseDescription;
        this.active = active;
        this.targetAudience = targetAudience;
        this.developedSkills = developedSkills;
        this.subcategoryId = subcategoryId;
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

    public String getCourseDescription() {
        return courseDescription;
    }

    public boolean isActive() {
        return active;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

}
