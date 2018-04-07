package com.skyforce.controller;

import com.skyforce.models.User;
import com.skyforce.security.role.Role;
import com.skyforce.services.implementations.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sulaymon on 18.03.2018.
 */
@Controller
public class AuthController {

    @Autowired
    private AuthenticationServiceImpl service;

    @PostMapping("/")
    public String login(Authentication authentication, HttpServletRequest request){
        if (authentication != null){
            User user = service.getUserByAuthentication(authentication);
            request.getSession().setAttribute("user", user);
            if (user.getRole().equals(Role.USER)){
                return "redirect:/lessons";
            }
        }
        return "redirect:/";
    }
}
