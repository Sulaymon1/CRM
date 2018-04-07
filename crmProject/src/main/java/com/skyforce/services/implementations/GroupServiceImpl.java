package com.skyforce.services.implementations;

import com.skyforce.models.Group;
import com.skyforce.repositories.GroupRepository;
import com.skyforce.services.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sulaymon on 24.03.2018.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void addNewGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }
}
