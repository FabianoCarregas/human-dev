package br.com.alura.humandev.validators;

import br.com.alura.humandev.dtos.forms.CategoryFormDto;
import br.com.alura.humandev.dtos.forms.SubcategoryFormDto;
import br.com.alura.humandev.repositories.CategoryRepository;
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

        if (subcategoryForm.getId() == null) {
            if (subcategoryRepository.existsByCode(subcategoryForm.getCode())) {
                errors.rejectValue("code", "code.already.exists");
            }
        } else {
            if (subcategoryRepository.existsByCodeWithDifferentId(subcategoryForm.getCode(), subcategoryForm.getId())) {
                errors.rejectValue("code", "code.already.exists");
            }
        }
    }
}
