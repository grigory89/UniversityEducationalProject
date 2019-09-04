package com.foxminded.university.services.Impl;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.dao.postgres.GroupDaoPostgres;
import com.foxminded.university.domain.Group;
import com.foxminded.university.services.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    private GroupDao groupDao = new GroupDaoPostgres();

    @Override
    public void create(Group group) {
        groupDao.create(group);
    }

    @Override
    public Group findById (int groupId) {
        return groupDao.findById(groupId);
    }

    @Override
    public List<Group> findAll () {
        return groupDao.findAll();
    }

    @Override
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    public void delete(int id) {
        groupDao.delete(id);
    }
}
