package com.skyforce.controller;

import com.skyforce.Validator.MemberValidator;
import com.skyforce.models.Member;
import com.skyforce.services.implementations.MemberServiceImpl;
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
import java.util.List;

/**
 * Created by Sulaymon on 11.03.2018.
 */
@Controller
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private MemberValidator memberValidator;

    @InitBinder("memberForm")
    public void initMemberForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(memberValidator);
    }

    @GetMapping("/members")
    public String getMembersPage(@ModelAttribute("model")ModelMap modelMap){
        List<Member> allMembers = memberService.getAllMembers();
        Collections.reverse(allMembers);
        modelMap.addAttribute("members", allMembers);
        return "membersPage";
    }

    @PostMapping("/addMember")
    public String addNewMember(@ModelAttribute("memberForm") @Valid Member member, BindingResult result,
                               RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            String defaultMessage = result.getAllErrors().get(0).getDefaultMessage();
            System.out.println(defaultMessage);
            redirectAttributes.addFlashAttribute("errors", defaultMessage);
            return "redirect:/members";
        }
        memberService.add(member);
        return "redirect:/members";
    }
}
