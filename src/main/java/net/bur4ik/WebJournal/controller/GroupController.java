package net.bur4ik.WebJournal.controller;

import net.bur4ik.WebJournal.model.Group;
import net.bur4ik.WebJournal.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GroupController {
    private GroupService groupService;

    @Autowired
    @Qualifier(value = "groupService")
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.GET)
    public String addGroupView(ModelMap model){
        Group group = new Group();
        List<Group> groupList = groupService.getGroupList();
        model.put("group", group);
        model.addAttribute("listGroup", groupList);
        return "addGroup";
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    public String addGroup(Group group, ModelMap model){
        group.setStudentsCount(0);
        groupService.addGroup(group);
        List<Group> groupList = groupService.getGroupList();
        model.addAttribute("listGroup", groupList);
        return "addGroup";
    }
}
