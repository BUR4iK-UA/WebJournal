package net.bur4ik.WebJournal.service;

import net.bur4ik.WebJournal.dao.StudentDao;
import net.bur4ik.WebJournal.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    @Transactional
    public void removeStudent(int idStudent) {
        studentDao.removeStudent(idStudent);
    }

    @Override
    @Transactional
    public Student getStudentById(int idStudent) {
        return studentDao.getStudentById(idStudent);
    }

    @Override
    @Transactional
    public List<Student> getStudentsList() {
        return studentDao.getStudentsList();
    }

    @Override
    @Transactional
    public List<Student> getStudentsByIdGroup(int idGroup) {
        return studentDao.getStudentsByIdGroup(idGroup);
    }
}
