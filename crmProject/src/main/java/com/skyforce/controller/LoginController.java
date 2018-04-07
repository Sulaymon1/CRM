package com.skyforce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Sulaymon on 18.03.2018.
 */
@Controller
public class LoginController {

    @GetMapping("/")
    public String login(){
        return "login";
    }
}
