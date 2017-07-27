package net.bur4ik.WebJournal.service;


import net.bur4ik.WebJournal.model.Subject;

import java.util.List;

public interface SubjectService {
    void addSubject(Subject subject);
    void updateSubject(Subject subject);
    void removeSubject(int idSubject);
    Subject getSubjectById(int idSubject);
    List<Subject> getListSubjectByGruop(int idGroup);
}
