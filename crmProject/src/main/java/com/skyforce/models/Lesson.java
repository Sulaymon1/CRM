package com.skyforce.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sulaymon on 23.03.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "lesson")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date ;
    private Long duration;
    // TODO: 24.03.2018 create entity group
    private String groups;
    private String topic;
    // TODO: 24.03.2018 create entity teacher
    private String teacher;
    private String homework;
}
