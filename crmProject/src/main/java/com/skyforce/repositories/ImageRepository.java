package com.skyforce.repositories;

import com.skyforce.models.ImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Sulaymon on 02.04.2018.
 */
public interface ImageRepository extends JpaRepository<ImageInfo, Long> {
    Optional<ImageInfo> findFirstByProfileId(Long id);
}
