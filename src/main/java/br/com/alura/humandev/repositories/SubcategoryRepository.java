package br.com.alura.humandev.repositories;

import br.com.alura.humandev.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

   Subcategory findByCode(String code);

}
