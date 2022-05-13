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
    private SubcategoryFormDto form;
    private String github = "github";
    private String frontend = "frontend";

    @BeforeEach
    void setUp() {
        repository = mock(SubcategoryRepository.class);
        validator = new SubcategoryValidator(repository);
        errors = mock(Errors.class);
        form = new SubcategoryFormDto();
    }

    @Test
    void when_subcategory_has_an_existent_code_should_not_add() {
        when(repository.existsByCode(github)).thenReturn(true);
        form.setCode(github);

        validator.validate(form, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }

    @Test
    void when_subcategory_has_a_nonexistent_code_should_add() {
        when(repository.existsByCode(github)).thenReturn(false);
        form.setCode(github);

        validator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_an_existent_code_and_an_existent_id_should_edit() {
        when(repository.existsByCodeAndIdNot(eq(github), not(eq(1L)))).thenReturn(true);
        form.setId(1L);
        form.setCode(github);

        validator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_a_nonexistent_code_and_an_existent_id_should_edit() {
        when(repository.existsByCodeAndIdNot(eq(github), not(eq(1L)))).thenReturn(true);
        form.setId(1L);
        form.setCode(frontend);

        validator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_a_nonexistent_code_and_a_nonexistent_id_should_edit() {
        when(repository.existsByCodeAndIdNot(eq(github), not(eq(1L)))).thenReturn(true);
        form.setId(2L);
        form.setCode(frontend);

        validator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_subcategory_has_an_existent_code_and_a_nonexistent_id_should_edit() {
        when(repository.existsByCodeAndIdNot(eq(github), not(eq(1L)))).thenReturn(true);
        form.setId(2L);
        form.setCode(github);

        validator.validate(form, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }
}