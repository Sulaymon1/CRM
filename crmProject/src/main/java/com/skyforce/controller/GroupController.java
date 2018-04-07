package com.skyforce.controller;

import com.skyforce.Validator.GroupValidator;
import com.skyforce.models.Group;
import com.skyforce.services.implementations.GroupServiceImpl;
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
public class GroupController {

    @Autowired
    private GroupValidator groupValidator;

    @InitBinder("groupForm")
    public void initValidatorGroupForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(groupValidator);
    }

    @Autowired
    private GroupServiceImpl groupService;

    @GetMapping("/groups")
    public String getGroupPage(@ModelAttribute("model")ModelMap modelMap){
        List<Group> allGroups = groupService.getAllGroups();
        modelMap.addAttribute("groups", allGroups);
        return "groupsPage";
    }

    @PostMapping("/addGroup")
    public String addNewGroup(@ModelAttribute("groupForm") @Valid Group group, BindingResult result,
                              RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            String defaultMessage = result.getAllErrors().get(0).getDefaultMessage();
            System.out.println(defaultMessage);
            redirectAttributes.addFlashAttribute("errors", defaultMessage);
            return "redirect:/groups";
        }

        groupService.addNewGroup(group);
        return "redirect:/groups";
    }
}
