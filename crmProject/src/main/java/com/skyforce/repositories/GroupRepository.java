package com.skyforce.repositories;

import com.skyforce.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Sulaymon on 24.03.2018.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findFirstByName(String name);
}
