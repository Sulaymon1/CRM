package com.skyforce.Validator;

import com.skyforce.models.User;
import com.skyforce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * Date 07.04.2018
 *
 * @author Hursanov Sulaymon
 * @version v1.0
 **/

@Component
public class UserRegValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(User.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        Optional<User> userOptional = userRepository.findFirstByEmail(user.getEmail());
        if (userOptional.isPresent()){
            errors.reject("bad.email", "С таким email уже зарегистрировано!");
        }
    }
}
