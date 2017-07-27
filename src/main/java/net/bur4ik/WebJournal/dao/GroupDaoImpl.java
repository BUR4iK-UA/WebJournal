package net.bur4ik.WebJournal.dao;

import net.bur4ik.WebJournal.model.Group;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGroup(Group group) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(group);
    }

    @Override
    public void updateGroup(Group group) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(group);
    }

    @Override
    public void removeGroup(int idGroup) {
        Session session = this.sessionFactory.getCurrentSession();
        Group group = (Group) session.load(Group.class, new Integer(idGroup));

        if (group != null){
            session.delete(group);
        }
    }

    @Override
    public Group getGroupById(int idGroup) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Group) session.load(Group.class, new Integer(idGroup));
    }


    @Override
    public List<Group> getGroupList() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Group").list();
    }
}
