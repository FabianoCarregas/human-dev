package br.com.alura.humandev.repositories;

import br.com.alura.humandev.entities.Category;
import br.com.alura.humandev.projections.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByActiveIsTrue();

    Optional<Category> findByCode(String code);

    @Query(value = """
            SELECT ca.name AS name, COUNT(co.id) AS coursesQuantity FROM category ca
            LEFT JOIN subcategory su ON ca.id = su.category_id
            LEFT JOIN course co ON su.id = co.subcategory_id
            GROUP BY ca.name
            Order by coursesQuantity DESC ;
            """, nativeQuery = true)
    List<CategoryProjection> findCategoryWithNumberOfCourses();

    @Query(value = """
            SELECT ca.id, ca.active, ca.category_description, ca.code, ca.hexa_color, ca.icon, ca.name, ca.ordination, ca.study_guide
            FROM category ca
            Inner join subcategory su ON ca.id = su.category_id
            Inner join course co ON su.id = co.subcategory_id
            WHERE (ca.`active` AND su.`active` AND co.`active`)
            GROUP BY ca.id, ca.active, ca.category_description, ca.code, ca.hexa_color, ca.icon, ca.name, ca.ordination, ca.study_guide
            ORDER BY ca.ordination;
            """, nativeQuery = true)
    List<Category> findAllCategoriesbyActiveCourses();

}
