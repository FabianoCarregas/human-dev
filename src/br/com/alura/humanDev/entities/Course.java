package br.com.alura.humanDev.entities;

import java.util.Collection;
import java.util.Collections;

import static br.com.alura.humanDev.validations.Validation.*;

public class Course implements Comparable<Course> {

    public String name;
    private String codeUrl;
    private int courseTimeHours;
    private boolean status;
    private String targetAudience;
    private String instructor;
    private String courseDescription;
    private String developedSkills;

    public Course(String name,
                  String codeUrl,
                  int courseTimeHours,
                  String instructor) {
        notNull(name);
        notBlank(name);
        this.name = name;
        this.codeUrl= codeUrl;
        validNumberHours(courseTimeHours);
        this.courseTimeHours = courseTimeHours;
        notNull(instructor);
        notBlank(instructor);
        this.instructor = instructor;
    }

    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                ", courseTimeHours=" + courseTimeHours +
                ", status=" + status +
                ", targetAudience='" + targetAudience + '\'' +
                ", instructor='" + instructor + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                '}';
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}