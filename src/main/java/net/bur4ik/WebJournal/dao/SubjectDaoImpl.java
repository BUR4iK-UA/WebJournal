package net.bur4ik.WebJournal.dao;


import net.bur4ik.WebJournal.model.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SubjectDaoImpl implements SubjectDao{


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


       public void addSubject(Subject subject) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(subject);
    }

    @Override
    public void removeSubject(int idSubject) {

    }

    @Override
    public Subject getSubjectById(int idSubject) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Subject where id_subject = :id").setInteger("id", idSubject);
        Subject subject = (Subject) query.uniqueResult();
        return subject;
    }

    @Override
    public List<Subject> getListSubjectByGruop(int idGroup) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Subject where id_group = :id").setInteger("id", idGroup);

        return query.list();
    }
}
