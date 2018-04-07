package com.skyforce.controller;

import com.skyforce.Validator.UserRegValidator;
import com.skyforce.models.User;
import com.skyforce.services.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRegValidator userRegValidator;

    @InitBinder("userForm")
    public void initValidator(WebDataBinder webDataBinder){
        webDataBinder.addValidators(userRegValidator);
    }

    @GetMapping("/user/profile")
    public String getUserPage(){
        return "userPage";
    }


    @PostMapping("/createUser")
    public String createNewUser(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            String defaultMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            System.out.println(defaultMessage);
            redirectAttributes.addFlashAttribute("errors", defaultMessage);
            return "redirect:/#signup";
        }

        userService.registerNewUser(user);
        return "redirect:/";
    }

}
