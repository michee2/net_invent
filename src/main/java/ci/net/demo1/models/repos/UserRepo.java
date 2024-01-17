package ci.net.demo1.models.repos;

import ci.net.demo1.models.HibernateConnection;
import ci.net.demo1.models.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class UserRepo implements Repo<User> {
    @Override
    public void create(User user) throws SQLException {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();

            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public User getById(Long userId) {
        Transaction tx = null;
        User user = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            user = session.get(User.class, userId);
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        Transaction tx = null;
        List<User> users = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            users = session.createQuery("from User", User.class).list();
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();

            session.close();

            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(User user) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            // start a tx
            tx = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(user);
            // commit tx
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean validate(String username, String password) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                    .uniqueResult();

            if(user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();

            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

}
