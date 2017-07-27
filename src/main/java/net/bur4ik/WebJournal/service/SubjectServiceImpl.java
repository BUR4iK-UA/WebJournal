package net.bur4ik.WebJournal.service;


import net.bur4ik.WebJournal.dao.SubjectDao;
import net.bur4ik.WebJournal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService{


    private SubjectDao subjectDao;



    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    @Transactional
    public void addSubject(Subject subject) {
        subjectDao.addSubject(subject);
    }

    @Override
    @Transactional
    public void updateSubject(Subject subject) {
        subjectDao.updateSubject(subject);
    }

    @Override
    @Transactional
    public void removeSubject(int idSubject) {
        subjectDao.removeSubject(idSubject);
    }

    @Override
    @Transactional
    public Subject getSubjectById(int idSubject) {
        return subjectDao.getSubjectById(idSubject);
    }

    @Override
    @Transactional
    public List<Subject> getListSubjectByGruop(int idGroup) {
        return subjectDao.getListSubjectByGruop(idGroup);
    }
}
