package com.skyforce.services.implementations;

import com.skyforce.models.Lesson;
import com.skyforce.repositories.LessonRepository;
import com.skyforce.services.interfaces.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sulaymon on 23.03.2018.
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public void addNewLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> getAllLessons(){
        List<Lesson> lessonList = lessonRepository.findAll();
        return lessonList;
    }
}
