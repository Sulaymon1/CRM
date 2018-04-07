package com.skyforce.repositories;

import com.skyforce.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Sulaymon on 24.03.2018.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findFirstByEmailOrPhoneNumber(String email, String number);
}
