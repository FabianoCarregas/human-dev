package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.CategoryFormDto;
import br.com.alura.humandev.dtos.forms.CourseFormDto;
import br.com.alura.humandev.repositories.CategoryRepository;
import br.com.alura.humandev.repositories.CourseRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CourseValidator implements Validator {

    private final CourseRepository courseRepository;

    public CourseValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CourseFormDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseFormDto courseForm = (CourseFormDto) target;

        if (courseForm.getId() == null) {
            if (courseRepository.existsByCode(courseForm.getCode())) {
                errors.rejectValue("code", "code.already.exists");
            }
        } else {
            if (courseRepository.existsByCodeWithDifferentId(courseForm.getCode(), courseForm.getId())) {
                errors.rejectValue("code", "code.already.exists");
            }
        }
    }
}
