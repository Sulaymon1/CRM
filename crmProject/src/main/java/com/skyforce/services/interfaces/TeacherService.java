package com.skyforce.services.interfaces;

import com.skyforce.models.Teacher;

import java.util.List;

/**
 * Created by Sulaymon on 24.03.2018.
 */
public interface TeacherService {
    void addNewTeacher(Teacher teacher);
    List<Teacher> getAllTeacher();
}
