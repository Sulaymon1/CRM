package com.skyforce.Validator;

import com.skyforce.models.Lesson;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Sulaymon on 23.03.2018.
 */
@Component
public class LessonValidator implements Validator {



    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(Lesson.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"duration","error.duration", "enter duration");
    }
}
