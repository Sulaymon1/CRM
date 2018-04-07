package com.skyforce.services.interfaces;

import com.skyforce.models.Lesson;

import java.util.List;

/**
 * Created by Sulaymon on 23.03.2018.
 */
public interface LessonService {
    void addNewLesson(Lesson lesson);
    List<Lesson> getAllLessons();
}
