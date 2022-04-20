package br.com.alura.humandev.projections;

import org.springframework.beans.factory.annotation.Value;

public interface SubcategoryLinkProjection {

    @Value("#{target.name}")
    String getName();
}
