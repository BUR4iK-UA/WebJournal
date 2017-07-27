package net.bur4ik.WebJournal.controller;

import net.bur4ik.WebJournal.model.Student;
import net.bur4ik.WebJournal.model.Subject;
import net.bur4ik.WebJournal.model.User;
import net.bur4ik.WebJournal.model.Valuation;
import net.bur4ik.WebJournal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
public class TestComnroller {

    private UserService service;
    private GroupService groupService;
    private ValuationService valuationService;
    private SubjectService subjectService;
    private StudentService studentService;

    @Autowired(required = true)
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    @Qualifier(value = "subjectService")
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    @Qualifier(value = "valuationService")
    public void setValuationService(ValuationService valuationService) {
        this.valuationService = valuationService;
    }

    @Autowired
    @Qualifier(value = "groupService")
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        if (service.authorization("root","root")) {
            return "ok";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login/auth", method = RequestMethod.GET)
    public String loginAuth(@ModelAttribute("user") User user, Model model){
        if (service.authorization(user.getLogin(),user.getPass())) {
            return "ok";
        }else {
            return "fail";
        }
    }
    @RequestMapping(value = "/addValsInNewDay/{idSubject}", method = RequestMethod.GET)
    public String valsForm(ModelMap model, @PathVariable("idSubject") int idSubject){
        Valuation valuation = new Valuation();
        valuation.setIdSubject(idSubject);
        valuationService.addValuation(valuation);
        return "redirect:/vals/subject/"+idSubject;
    }

    @RequestMapping(value = "/addvals", method = RequestMethod.POST)
    public String addVals(Valuation valuation, ModelMap model){
        valuationService.addValuation(valuation);
        return "testVal";
    }

    @RequestMapping(value = "/vals/subject/{id}", method = RequestMethod.GET)
    public String vals(@PathVariable("id") int id, ModelMap model){
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("idSubject",subject.getId());
        List<Student> studentList = studentService.getStudentsByIdGroup(subject.getIdGroup());
        System.out.println(studentList.toString());
        Map<Student,List<Valuation>> Map = new LinkedHashMap<Student, List<Valuation>>();
        for (Student student : studentList){
            Map.put(student,valuationService.getListValByIdStudentAndIdSubject(student.getId(),id));
        }
        model.addAttribute("list", Map.values());
        model.addAttribute("map", Map);
        return "valsListBySubject";
    }

    @RequestMapping(value = "/selectGroup/{id}", method = RequestMethod.GET)
    public String selectGroup(@PathVariable("id") int id,ModelMap model){
        model.addAttribute("listSubject", subjectService.getListSubjectByGruop(id));
        return "listSubjectByGroup";
    }

    @RequestMapping(value = "/updateval/{id}", method = RequestMethod.GET)
    public String updateVal(@PathVariable("id") int id,@RequestParam("valuation") int val){
        Valuation valuation = valuationService.getValuationById(id);
        System.out.println(valuation);
        valuation.setValue(val);
        valuationService.updateValuation(valuation);

        return "/vals/subject/"+valuation.getIdSubject();
    }
}
/*show user
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		User user = userService.findById(id);
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);

		return "users/show";


ublic String addGroup(Group group, ModelMap model){
        group.setStudentsCount(0);
        groupService.addGroup(group);
        List<Group> groupList = groupService.getGroupList();
        model.addAttribute("listGroup", groupList);
        return "addGroup";
    }
	}*/