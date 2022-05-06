package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.CourseFormDto;
import br.com.alura.humandev.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

class CourseValidatorTest {

    private CourseRepository repository;
    private CourseValidator validator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        repository = mock(CourseRepository.class);
        validator = new CourseValidator(repository);
        errors = mock(Errors.class);
    }

    @Test
    void when_course_has_an_existent_code_should_not_add() {
        when(repository.existsByCode("aws")).thenReturn(true);

        CourseFormDto courseFormDto = new CourseFormDto();
        courseFormDto.setCode("aws");

        validator.validate(courseFormDto, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }

    @Test
    void when_course_has_a_nonexistent_code_should_add() {
        when(repository.existsByCode("aws")).thenReturn(false);

        CourseFormDto courseFormDto = new CourseFormDto();
        courseFormDto.setCode("aws");

        validator.validate(courseFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_course_has_an_existent_code_and_an_existent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("aws"), not(eq(1L)))).thenReturn(true);

        CourseFormDto courseFormDto = new CourseFormDto();
        courseFormDto.setCode("aws");
        courseFormDto.setId(1L);

        validator.validate(courseFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_course_has_a_nonexistent_code_and_an_existent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("aws"), not(eq(1L)))).thenReturn(true);

        CourseFormDto courseFormDto = new CourseFormDto();
        courseFormDto.setCode("java");
        courseFormDto.setId(1L);

        validator.validate(courseFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_course_has_a_nonexistent_code_and_a_nonexistent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("aws"), not(eq(1L)))).thenReturn(true);

        CourseFormDto courseFormDto = new CourseFormDto();
        courseFormDto.setCode("java");
        courseFormDto.setId(2L);

        validator.validate(courseFormDto, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void when_course_has_an_existent_code_and_a_nonexistent_id_should_edit() {
        when(repository.existsByCodeWithDifferentId(eq("aws"), not(eq(1L)))).thenReturn(true);

        CourseFormDto courseFormDto = new CourseFormDto();
        courseFormDto.setCode("aws");
        courseFormDto.setId(2L);

        validator.validate(courseFormDto, errors);
        verify(errors).rejectValue("code", "code.already.exists");
    }
}