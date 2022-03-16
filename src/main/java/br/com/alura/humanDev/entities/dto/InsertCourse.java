package br.com.alura.humanDev.entities.dto;

public class InsertCourse {

    private String name;
    private String codeUrl;
    private int courseTimeHours;
    private String instructor;
    private int subcategoryId;

    public InsertCourse(String name, String codeUrl, int courseTimeHours, String instructor, int subcategoryId) {
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
