package br.com.alura.humandev.projections;

import java.util.List;

public interface SubcategoryLinkProjection {

    String getName();
    String getCode();
    List<CourseLinkProjection> getCourses();

}
