package com.skyforce.controller;

import com.skyforce.Validator.LessonValidator;
import com.skyforce.models.Lesson;
import com.skyforce.services.implementations.LessonServiceImpl;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sulaymon on 23.03.2018.
 */
@Controller
public class LessonController {

    @Autowired
    private LessonServiceImpl lessonService;
    @Autowired
    private LessonValidator validator;

    @InitBinder("LessonForm")
    public void lessonValidator(WebDataBinder webDataBinder){
        webDataBinder.addValidators(validator);
    }

    @GetMapping("/lessons")
    public String getLessonsPage(@ModelAttribute("model")ModelMap map){
        List<Lesson> lessons = lessonService.getAllLessons();
        Collections.reverse(lessons);
        map.addAttribute("lessons", lessons);
        return "lessonsPage";
    }

    @PostMapping("/addLesson")
    public String addLesson(@ModelAttribute("LessonForm") @Valid Lesson lesson, BindingResult result,
                            RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            String defaultMessage = result.getAllErrors().get(0).getDefaultMessage();
            System.out.println(defaultMessage);
            redirectAttributes.addFlashAttribute("errors", defaultMessage);
            return "redirect:/lessons";
        }
        lessonService.addNewLesson(lesson);
        return "redirect:/lessons";
    }
}
