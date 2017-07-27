package net.bur4ik.WebJournal.dao;

import net.bur4ik.WebJournal.model.Subject;

import java.util.List;

public interface SubjectDao {
    void addSubject(Subject subject);
    void updateSubject(Subject subject);
    void removeSubject(int idSubject);
    Subject getSubjectById(int idSubject);
    List<Subject> getListSubjectByGruop(int idGroup);
}
