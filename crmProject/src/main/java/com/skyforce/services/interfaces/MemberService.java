package com.skyforce.services.interfaces;

import com.skyforce.models.ImageInfo;
import com.skyforce.models.Member;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sulaymon on 11.03.2018.
 */
public interface MemberService {
    void add(Member member);
    Member getMember(Long id);
    List<Member> getAllMembers();
    Optional<Member> getOptionalMember(Long id);
    void getProfilePicture(Long id,HttpServletResponse response);
    void saveImage(ImageInfo imageInfo);
}
