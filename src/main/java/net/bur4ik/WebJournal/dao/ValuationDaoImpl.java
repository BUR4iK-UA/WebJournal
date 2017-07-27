package net.bur4ik.WebJournal.dao;

import net.bur4ik.WebJournal.model.Group;
import net.bur4ik.WebJournal.model.Student;
import net.bur4ik.WebJournal.model.Subject;
import net.bur4ik.WebJournal.model.Valuation;
import net.bur4ik.WebJournal.service.StudentService;
import net.bur4ik.WebJournal.service.SubjectService;
import net.bur4ik.WebJournal.service.ValuationService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public class ValuationDaoImpl implements ValuationDao {

    private SessionFactory sessionFactory;

    private StudentService studentService;

    private SubjectService subjectService;

    private ValuationService valuationService;

    @Autowired
    @Qualifier(value = "valuationService")
    public void setValuationService(ValuationService valuationService) {
        this.valuationService = valuationService;
    }

    @Autowired
    @Qualifier(value = "subjectService")
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addValuation(Valuation valuation) {
        Session session = sessionFactory.getCurrentSession();

        Subject subject = subjectService.getSubjectById(valuation.getIdSubject());
        Group group = (Group)  session.load(Group.class, new Integer(subject.getIdGroup()));
        List<Student> studentList = studentService.getStudentsByIdGroup(group.getId());

            for (Student student : studentList){
                Valuation valuation1 = new Valuation();
                valuation1.setDate(Calendar.getInstance().getTime());
                valuation1.setIdSubject(subject.getId());
                valuation1.setIdStudent(student.getId());
                valuation1.setValue(-1);
                valuation1.setPresense(true);
                valuationService.saveValuation(valuation1);
            }


    }

    @Override
    public void saveValuation(Valuation valuation) {
        Session session = sessionFactory.getCurrentSession();
            session.save(valuation);
    }

    @Override
    public void updateValuation(Valuation valuation) {
        Session session = sessionFactory.getCurrentSession();
        session.update(valuation);
    }

    @Override
    public Valuation getValuationById(int idVal) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Valuation where id_valuation = :id").setInteger("id", idVal);
        Valuation valuation = (Valuation) query.uniqueResult();
        return valuation;
    }


    @Override
    public List<Valuation> getListValuations() {
        Session session = sessionFactory.getCurrentSession();
        List<Valuation> valuationList = session.createQuery("from Valuation").list();
        return valuationList;
    }

    @Override
    public List<Valuation> getListValuationsByIdSubject(int idSubject) {
        Session session = sessionFactory.getCurrentSession();
        List<Valuation> valuationList = session.createQuery("from Valuation where id_subject = :id").setInteger("id", idSubject).list();
        return valuationList;
    }

    @Override
    public List<Valuation> getListValByIdStudentAndIdSubject(int idStudent, int idSubject) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("from Valuation where id_subject = :idSubject and id_student = :idStudent");
        query.setInteger("idSubject", idSubject);
        query.setInteger("idStudent", idStudent);

        return query.list();
    }
}
