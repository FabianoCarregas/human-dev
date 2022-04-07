package br.com.alura.humandev.repositories;

import br.com.alura.humandev.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByActiveIsTrue();

    Category findByCode(String code);
}
