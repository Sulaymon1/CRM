package com.skyforce.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sulaymon on 30.03.2018.
 */
@Getter
@Setter
public class MemberUpdateFormDTO {
    @NotNull
    @Size(min = 5)
    private String address;

    @NotNull
    @Size(min = 5)
    private String email;

    @NotNull
    @Size(min = 9)
    private String phoneNumber;
    private MultipartFile file;
}
