package br.com.alura.humandev.repositories;

import br.com.alura.humandev.entities.Course;
import br.com.alura.humandev.entities.Subcategory;
import br.com.alura.humandev.projections.InstructorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllBySubcategory(Subcategory subcategory, Pageable pageable);

    @Query(value = """
            SELECT instructor , COUNT(*) AS coursesNumber
            FROM course GROUP BY instructor 
            ORDER BY coursesNumber Desc limit 1
            """, nativeQuery = true)
    InstructorProjection findInstructor();

    Optional<Course> findByCode(String code);
}
