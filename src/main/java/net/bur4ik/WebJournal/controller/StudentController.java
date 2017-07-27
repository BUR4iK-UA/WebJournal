package net.bur4ik.WebJournal.controller;

        import net.bur4ik.WebJournal.model.Student;
        import net.bur4ik.WebJournal.service.GroupService;
        import net.bur4ik.WebJournal.service.StudentService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController {
    private StudentService studentService;
    private GroupService groupService;

    @Autowired
    @Qualifier(value = "groupService")
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Autowired(required = true)
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String students(ModelMap model) {
        model.put("student", new Student());
        model.addAttribute("listStudents", studentService.getStudentsList());
        model.addAttribute("listGroups", groupService.getGroupList());
        return "students";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String addStudent(Student student, ModelMap model) {
        studentService.addStudent(student);
        model.put("student", new Student());
        model.addAttribute("listStudents", studentService.getStudentsList());
        model.addAttribute("listGroups", groupService.getGroupList());
        return "students";
    }

    @RequestMapping("/students/remove/{id}")
    public String revomeStudent(@PathVariable("id") int id) {
        studentService.removeStudent(id);
        return "redirect:/students";
    }
}
