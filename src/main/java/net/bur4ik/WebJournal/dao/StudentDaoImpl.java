package net.bur4ik.WebJournal.dao;

import net.bur4ik.WebJournal.model.Group;
import net.bur4ik.WebJournal.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        Group group = (Group) session.load(Group.class, student.getIdGroup());
        group.setStudentsCount(group.getStudentsCount() + 1);
        session.update(group);
        session.persist(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    public void removeStudent(int idStudent) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(idStudent));

        if (student != null) {
            session.delete(student);
        }
    }

    @Override
    public Student getStudentById(int idStudent) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(idStudent));
        return student;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getStudentsList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student order by lastName").list();
        return studentList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getStudentsByIdGroup(int idGroup) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Student where id_group = :id order by lastName").setInteger("id", idGroup);
        List<Student> studentList = query.list();
        return studentList;
    }
}
