package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.CategoryFormDto;
import br.com.alura.humandev.repositories.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoryValidator implements Validator {

    private final CategoryRepository categoryRepository;

    public CategoryValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryFormDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryFormDto categoryForm = (CategoryFormDto) target;
        Long formId = categoryForm.getId();
        String formCode = categoryForm.getCode();

        if (formId == null && categoryRepository.existsByCode(formCode)) {
            errors.rejectValue("code", "code.already.exists");
        }

        if (formId != null && categoryRepository.existsByCodeAndIdNot(formCode, formId)) {
            errors.rejectValue("code", "code.already.exists");
        }
    }
}
