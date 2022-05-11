package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.CourseFormDto;
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
        Long formId = courseForm.getId();
        String formCode = courseForm.getCode();

        if (formId == null && courseRepository.existsByCode(formCode)) {
            errors.rejectValue("code", "code.already.exists");
        }

        if (formId != null && courseRepository.existsByCodeAndIdNot(formCode, formId)) {
            errors.rejectValue("code", "code.already.exists");
        }
    }
}
