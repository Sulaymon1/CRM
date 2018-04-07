package com.skyforce.Validator;

import com.skyforce.models.Member;
import com.skyforce.repositories.MemberRepository;
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
public class MemberValidator implements Validator {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(Member.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        // TODO: 24.03.2018 must return 1 object 
        Optional<Member> memberOptional = memberRepository.findFirstByEmailOrPhoneNumber(member.getEmail(), member.getPhoneNumber());
        if (memberOptional.isPresent()){
            errors.reject("bad.registration","Already registered with such number or email! ");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","empty.name", "Name cannot be empty!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname","empty.surname", "Surname cannot be empty!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","empty.email", "Email can't be empty!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber","empty.phoneNumber", "Phone number can't be empty!");
    }
}
