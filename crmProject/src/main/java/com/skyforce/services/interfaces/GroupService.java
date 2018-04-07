package com.skyforce.services.interfaces;

import com.skyforce.models.Group;

import java.util.List;

/**
 * Created by Sulaymon on 24.03.2018.
 */
public interface GroupService {
    void addNewGroup(Group group);
    List<Group> getAllGroups();
}
