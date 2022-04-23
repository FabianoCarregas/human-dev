package br.com.alura.humandev.projections;

import java.util.List;

public interface CategoryLinkProjection {

    String getName();
    String getCode();
    String getIcon();
    List<SubcategoryLinkProjection> getSubcategories();
}
