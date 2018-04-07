package com.skyforce.controller;

import com.skyforce.Validator.TeacherValidator;
import com.skyforce.models.Teacher;
import com.skyforce.services.implementations.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Sulaymon on 24.03.2018.
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherValidator teacherValidator;

    @InitBinder("teacherForm")
    public void initTeacherValidator(WebDataBinder webDataBinder){
        webDataBinder.addValidators(teacherValidator);
    }

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping("/teachers")
    public String getTeachersPage(@ModelAttribute("model")ModelMap modelMap){
        List<Teacher> teacherList = teacherService.getAllTeacher();
        modelMap.addAttribute("teachers", teacherList);
        return "teachersPage";
    }

    @PostMapping("/addTeacher")
    public String addNewTeacher(@ModelAttribute("teacherForm") @Valid Teacher teacher, BindingResult result,
                                RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/teachers";
        }

        teacherService.addNewTeacher(teacher);
        return "redirect:/teachers";
    }

}
