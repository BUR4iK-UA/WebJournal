package net.bur4ik.WebJournal.dao;

import net.bur4ik.WebJournal.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean authorization(String login, String pass) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where user_login = :login").setString("login",login);
        User user = (User) query.uniqueResult();
        if (user!=null) {
            if (login.equals(user.getLogin()) && pass.equals(user.getPass())) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }

    }
}
/*@Override
    public Book getBookById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + book);

        return book;

        ession session = null;
    List busses = new ArrayList<Bus>();
    try {
      session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.beginTransaction();
      Long route_id = route.getId();
      Query query = session.createQuery(«from Bus where route_id = :routeId „).setLong(“routeId», route_id);
      busses = (List<Bus>) query.list();
      session.getTransaction().commit();

    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return busses;
  }
    }*/