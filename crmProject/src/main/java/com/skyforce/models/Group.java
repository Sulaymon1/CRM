package com.skyforce.models;

import com.skyforce.status.Level;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by Sulaymon on 24.03.2018.
 */
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startLessonDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endLessonDate;

    @Enumerated(EnumType.STRING)
    private Level level;
    @ManyToMany(mappedBy = "groups",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Member> members;
    private String teacher;
}
