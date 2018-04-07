package com.skyforce.Validator;

import com.skyforce.models.Group;
import com.skyforce.repositories.GroupRepository;
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
public class GroupValidator implements Validator {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(Group.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        Group group = (Group) target;

        Optional<Group> groupOptional = groupRepository.findFirstByName(group.getName());
        if (groupOptional.isPresent()){
            errors.reject("bad.group", "Already crated with such name!");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name","Name of group can't be empty!");
    }
}
