package com.skyforce.services.implementations;

import com.skyforce.models.Teacher;
import com.skyforce.repositories.TeacherRepository;
import com.skyforce.services.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sulaymon on 24.03.2018.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void addNewTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList;
    }
}
