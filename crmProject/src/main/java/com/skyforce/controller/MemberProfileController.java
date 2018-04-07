package com.skyforce.controller;

import com.skyforce.form.MemberUpdateFormDTO;
import com.skyforce.models.Comment;
import com.skyforce.models.ImageInfo;
import com.skyforce.models.Member;
import com.skyforce.services.implementations.MemberServiceImpl;
import com.skyforce.services.implementations.CommentServiceImpl;
import com.skyforce.utils.ImageStorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sulaymon on 25.03.2018.
 */
@Controller
public class MemberProfileController {

    @Autowired
    private MemberServiceImpl memberService;
    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private ImageStorageUtil imageStorageUtil;

    @GetMapping("/profile/{member-id}")
    public String getProfilePage(@ModelAttribute("model") ModelMap modelMap,
                                 @PathVariable("member-id") Long id){
        Member member = memberService.getMember(id);
        List<Comment> commentList = commentService.getAllComments(id);
        if (member == null){
            return "redirect:/members";
        }
        modelMap.addAttribute("comments", commentList);
        modelMap.addAttribute("member", member);
        return "profile";
    }

    @PostMapping("/addComment")
    public String addNewComment(@ModelAttribute("comment") Comment comment, BindingResult result,
                                RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors().get(0).getDefaultMessage());
            // TODO: 25.03.2018 send correct
            return "redirect:/members";
        }
        commentService.addNewComment(comment);
        return "redirect:/profile/"+comment.getMemberId();
    }

    @PostMapping("/updateProfile/{id}")
    public String updateProfile(@ModelAttribute("model") ModelMap map, @PathVariable("id") Long id, @Valid MemberUpdateFormDTO memberForm){
        Optional<Member> memberOptional = memberService.getOptionalMember(id);
        if (memberOptional.isPresent()){
                Member member = Member.builder()
                        .address(memberForm.getAddress())
                        .email(memberForm.getEmail())
                        .phoneNumber(memberForm.getPhoneNumber())
                        .build();
                memberService.add(member);
        }
        return "redirect:/profile/"+id;
    }

    @PostMapping("/updateProfileImage/{id}")
    public String updateProfileImage(@PathVariable("id") Long id, MultipartFile file){
        Optional<Member> optionalMember = memberService.getOptionalMember(id);
        if (optionalMember.isPresent()){
            if (file.getSize()<4194304){ // 4MB
                ImageInfo imageInfo = imageStorageUtil.convertFromMultipartFileAndSave(file);
                imageInfo.setProfileId(id);
                memberService.saveImage(imageInfo);
            }

        }
        return "redirect:/profile/"+id;
    }

    @GetMapping("/profilePic/{id}")
    public void getProfilePicture(@PathVariable("id") Long id, HttpServletResponse response){
        memberService.getProfilePicture(id,response);
    }
}
