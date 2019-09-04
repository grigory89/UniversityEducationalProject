package com.foxminded.university.services;

import com.foxminded.university.domain.Group;

import java.util.List;

public interface GroupService {
    void create(Group group);

    Group findById(int groupId);

    List<Group> findAll();

    void update(Group group);

    void delete(int id);
}
