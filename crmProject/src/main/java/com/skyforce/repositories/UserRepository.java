package com.skyforce.repositories;

import com.skyforce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Sulaymon on 18.03.2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findFirstByEmail(String email);
}
