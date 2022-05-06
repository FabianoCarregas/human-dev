package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.CategoryFormDto;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

class CategoryValidatorTest {

    private CategoryRepository repository;
    private CategoryValidator categoryValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        repository = mock(CategoryRepository.class);
        categoryValidator = new CategoryValidator(repository);
        errors = mock(Errors.class);
    }

    @Test
    void when_category_has_an_existent_code_should_not_add() {
        when(repository.existsByCode("java")).thenReturn(true);

        CategoryFormDto categoryFormDto = new CategoryFormDto();
        categoryFormDto.setCode("java");

        categoryValidator.validate(categoryFormDto, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }

    @Test
    void when_category_has_a_nonexistent_code_should_add() {
        when(repository.existsByCode("java")).thenReturn(false);

        CategoryFormDto categoryFormDto = new CategoryFormDto();
        categoryFormDto.setCode("java");

        categoryValidator.validate(categoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(),anyString());
    }

    @Test
    void when_category_has_an_existent_code_and_an_existent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("java"), not(eq(1L)))).thenReturn(true);

        CategoryFormDto categoryFormDto = new CategoryFormDto();
        categoryFormDto.setCode("java");
        categoryFormDto.setId(1L);

        categoryValidator.validate(categoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_category_has_an_existent_id_and_a_nonexistent_code_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("java"), not(eq(1L)))).thenReturn(true);
        CategoryFormDto categoryFormDto = new CategoryFormDto();

        categoryFormDto.setCode("aws");
        categoryFormDto.setId(1L);

        categoryValidator.validate(categoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_category_has_a_nonexistent_id_and_a_nonexistent_code_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("java"), not(eq(1L)))).thenReturn(true);
        CategoryFormDto categoryFormDto = new CategoryFormDto();

        categoryFormDto.setCode("aws");
        categoryFormDto.setId(2L);

        categoryValidator.validate(categoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_category_has_a_nonexistent_id_and_an_existent_code_should_Not_edit() {
        when(repository.existsByCodeWithDifferentId(eq("java"), not(eq(1L)))).thenReturn(true);
        CategoryFormDto categoryFormDto = new CategoryFormDto();

        categoryFormDto.setCode("java");
        categoryFormDto.setId(2L);

        categoryValidator.validate(categoryFormDto, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }
}