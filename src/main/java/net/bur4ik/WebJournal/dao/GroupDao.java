package net.bur4ik.WebJournal.dao;

import net.bur4ik.WebJournal.model.Group;

import java.util.List;

public interface GroupDao {
    void addGroup(Group group);
    void updateGroup(Group group);
    void removeGroup(int idGroup);
    Group getGroupById(int idGroup);
    List<Group> getGroupList();

}
