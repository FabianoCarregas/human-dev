package br.com.alura.humandev.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{name.invalid}")
    private String name;

    @Min(1)
    @Max(value = 20, message = "{number.max}")
    @Positive(message = "{number.invalid}")
    private Integer courseTimeHours;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9-]+$", message = "{code.invalid}")
    private String code;
    private boolean active = true;
    private String targetAudience;

    @NotBlank(message = "{name.invalid}")
    private String instructor;
    private String courseDescription;
    private String developedSkills;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subcategory subcategory;

    public Course(String name,
                  String code,
                  Integer courseTimeHours,
                  boolean active,
                  String targetAudience,
                  String instructor,
                  String courseDescription,
                  String developedSkills,
                  Subcategory subcategory) {
        this.name = name;
        this.code = code;
        this.courseTimeHours = courseTimeHours;
        this.active = active;
        this.targetAudience = targetAudience;
        this.instructor = instructor;
        this.courseDescription = courseDescription;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

}