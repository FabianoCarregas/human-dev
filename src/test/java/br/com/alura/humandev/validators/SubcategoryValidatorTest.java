package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.SubcategoryFormDto;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

class SubcategoryValidatorTest {

    private SubcategoryRepository repository;
    private SubcategoryValidator validator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        repository = mock(SubcategoryRepository.class);
        validator = new SubcategoryValidator(repository);
        errors = mock(Errors.class);
    }

    @Test
    void when_subcategory_has_an_existent_code_should_not_add() {
        when(repository.existsByCode("github")).thenReturn(true);

        SubcategoryFormDto subcategoryFormDto = new SubcategoryFormDto();
        subcategoryFormDto.setCode("github");

        validator.validate(subcategoryFormDto, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }

    @Test
    void when_subcategory_has_a_nonexistent_code_should_add() {
        when(repository.existsByCode("github")).thenReturn(false);

        SubcategoryFormDto subcategoryFormDto = new SubcategoryFormDto();
        subcategoryFormDto.setCode("github");

        validator.validate(subcategoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_an_existent_code_and_an_existent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("github"), not(eq(1L)))).thenReturn(true);

        SubcategoryFormDto subcategoryFormDto = new SubcategoryFormDto();
        subcategoryFormDto.setId(1L);
        subcategoryFormDto.setCode("github");

        validator.validate(subcategoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_a_nonexistent_code_and_an_existent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("github"), not(eq(1L)))).thenReturn(true);

        SubcategoryFormDto subcategoryFormDto = new SubcategoryFormDto();
        subcategoryFormDto.setId(1L);
        subcategoryFormDto.setCode("git");

        validator.validate(subcategoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_a_nonexistent_code_and_a_nonexistent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("github"), not(eq(1L)))).thenReturn(true);

        SubcategoryFormDto subcategoryFormDto = new SubcategoryFormDto();
        subcategoryFormDto.setId(2L);
        subcategoryFormDto.setCode("git");

        validator.validate(subcategoryFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_an_existent_code_and_a_nonexistent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("github"), not(eq(1L)))).thenReturn(true);

        SubcategoryFormDto subcategoryFormDto = new SubcategoryFormDto();
        subcategoryFormDto.setId(2L);
        subcategoryFormDto.setCode("github");

        validator.validate(subcategoryFormDto, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }

}