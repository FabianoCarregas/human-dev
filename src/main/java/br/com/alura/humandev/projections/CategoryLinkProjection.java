package br.com.alura.humandev.projections;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CategoryLinkProjection {

    @Value("#{target.name}")
    String getName();

    @Value("#{target.code}")
    String getCode();

    @Value("#{target.icon}")
    String getIcon();

    @Value("#{target.subcategories}")
    List<SubcategoryLinkProjection> getSubcategories();
}
