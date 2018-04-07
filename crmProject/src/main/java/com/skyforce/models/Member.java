package com.skyforce.models;

import com.skyforce.status.Gender;
import com.skyforce.status.Status;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Sulaymon on 11.03.2018.
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    // TODO: 24.03.2018 create entity group
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groups;
    // TODO: 24.03.2018 create entity rest
    private String rest;
    private Status status;
    private String phoneNumber;
    private String email;
    // TODO: 24.03.2018 create entity customer
    private String customer;
    private String responsibleTeacher;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String filePath;
    private String address;
    @OneToOne(targetEntity = ImageInfo.class)
    private ImageInfo imageInfo;
}
