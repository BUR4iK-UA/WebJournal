package net.bur4ik.WebJournal.service;


import net.bur4ik.WebJournal.model.Group;

import java.util.List;

public interface GroupService {
    void addGroup(Group group);
    void updateGroup(Group group);
    void removeGroup(int idGroup);
    Group getGroupById(int idGroup);
    List<Group> getGroupList();
}
