package com.skyforce.Validator;

import com.skyforce.models.Teacher;
import com.skyforce.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * Created by Sulaymon on 24.03.2018.
 */
@Component
public class TeacherValidator implements Validator {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(Teacher.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        Teacher teacher = (Teacher) target;

        Optional<Teacher> teacherOptional = teacherRepository.findFirstByEmailOrPhoneNumber(teacher.getEmail(), teacher.getPhoneNumber());
        if (teacherOptional.isPresent()){
            errors.reject("bad.teacher", "Already registered with such number or email!");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","empty.name", "Name cannot be empty!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname","empty.surname", "Surname cannot be empty!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","empty.email", "Email can't be empty!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber","empty.phoneNumber", "Phone number can't be empty!");

    }
}
