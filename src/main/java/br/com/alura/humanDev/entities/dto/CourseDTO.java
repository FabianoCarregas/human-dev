package br.com.alura.humanDev.entities.dto;

import br.com.alura.humanDev.entities.Subcategory;

public class CourseDTO {

    private String name;
    private String codeUrl;
    private int courseTimeHours;
    private String instructor;
    private int subcategoryId;

    public CourseDTO(String name, String codeUrl, int courseTimeHours, String instructor, int subcategoryId) {
        this.name = name;
        this.codeUrl = codeUrl;
        this.courseTimeHours = courseTimeHours;
        this.instructor = instructor;
        this.subcategoryId = subcategoryId;
    }

    public String getName() {
        return name;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public int getCourseTimeHours() {
        return courseTimeHours;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }
}
