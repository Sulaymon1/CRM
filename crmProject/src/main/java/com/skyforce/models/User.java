package com.skyforce.models;

import com.skyforce.security.role.Role;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sulaymon on 18.03.2018.
 */


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @NotNull
    @Column(unique = true)
    private String email;
    private Long phoneNumber;
    private String hashPassword;

    @Enumerated(EnumType.STRING)
    private Role role;
}
