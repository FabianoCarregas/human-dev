package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.SubcategoryFormDto;
import br.com.alura.humandev.repositories.SubcategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SubcategoryValidator implements Validator {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryValidator(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SubcategoryFormDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SubcategoryFormDto subcategoryForm = (SubcategoryFormDto) target;
        Long formId = subcategoryForm.getId();
        String formCode = subcategoryForm.getCode();

        if (formId == null && subcategoryRepository.existsByCode(formCode)) {
            errors.rejectValue("code", "code.already.exists");
        }

        if (formId != null && subcategoryRepository.existsByCodeAndIdNot(formCode, formId)) {
            errors.rejectValue("code", "code.already.exists");
        }
    }
}
