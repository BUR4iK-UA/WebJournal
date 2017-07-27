package net.bur4ik.WebJournal.dao;

import net.bur4ik.WebJournal.model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    void updateStudent(Student student);

    void removeStudent(int idStudent);

    Student getStudentById(int idStudent);

    List<Student> getStudentsList();

    List<Student> getStudentsByIdGroup(int idGroup);
}
