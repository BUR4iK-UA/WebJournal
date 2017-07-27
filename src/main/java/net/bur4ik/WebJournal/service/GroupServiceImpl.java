package net.bur4ik.WebJournal.service;

import net.bur4ik.WebJournal.dao.GroupDao;
import net.bur4ik.WebJournal.model.Group;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    @Transactional
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }

    @Override
    @Transactional
    public void updateGroup(Group group) {
        groupDao.updateGroup(group);
    }

    @Override
    @Transactional
    public void removeGroup(int idGroup) {
        groupDao.removeGroup(idGroup);
    }

    @Override
    @Transactional
    public Group getGroupById(int idGroup) {
        return groupDao.getGroupById(idGroup);
    }

    @Override
    @Transactional
    public List<Group> getGroupList() {
        return groupDao.getGroupList();
    }
}
