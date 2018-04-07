package com.skyforce.services.implementations;

import com.skyforce.models.ImageInfo;
import com.skyforce.models.Member;
import com.skyforce.repositories.MemberRepository;
import com.skyforce.repositories.ImageRepository;
import com.skyforce.services.interfaces.MemberService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sulaymon on 11.03.2018.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public void add(Member member) {
        Member member1 = memberRepository.save(member);
        ImageInfo imageInfo = ImageInfo.builder()
                .profileId(member1.getId())
                // TODO: 07.04.2018 put default field value in models 
                .url("pic/default.png")
                .type("image/png")
                .build();
        saveImage(imageInfo);

    }

    @Override
    public Member getMember(Long id) {
        Member member = memberRepository.getOne(id);
        return member;
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> all = memberRepository.findAll();
        return all;
    }

    @Override
    public Optional<Member> getOptionalMember(Long id){
        return memberRepository.findFirstById(id);
    }

    @Override
    public void saveImage(ImageInfo imageInfo){
        Optional<ImageInfo> imageInfoOptional = imageRepository.findFirstByProfileId(imageInfo.getProfileId());
        if (imageInfoOptional.isPresent()){
            imageRepository.delete(imageInfo.getProfileId());
        }
        imageRepository.save(imageInfo);
    }

    @Override
    public void getProfilePicture(Long id, HttpServletResponse response) {
        Optional<ImageInfo> imageInfoOptional = imageRepository.findFirstByProfileId(id);
        if (imageInfoOptional.isPresent()){
            ImageInfo imageInfo = imageInfoOptional.get();
            File file = new File(imageInfo.getUrl());
            try {
                InputStream is = new FileInputStream(file);
                response.setContentType(imageInfo.getType());
                IOUtils.copy(is,response.getOutputStream() );
                response.flushBuffer();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
