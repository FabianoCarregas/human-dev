package br.com.alura.humandev.repositories;

import br.com.alura.humandev.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

   Optional<Subcategory> findByCode(String code);

   @Query(value = """
         SELECT distinct s FROM Subcategory s
         INNER JOIN Category c 
         ON c.id = s.category.id
         INNER JOIN Course co 
         ON s.id = co.subcategory.id
         WHERE c.active = true and s.active = true and co.active = true AND c.code = :code
         """)
   List<Subcategory> findActiveSubcategoryByCategoryCode(String code);

}
