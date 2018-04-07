package com.skyforce.repositories;

import com.skyforce.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Sulaymon on 23.03.2018.
 */
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
