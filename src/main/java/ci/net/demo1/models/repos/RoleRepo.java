package ci.net.demo1.models.repos;

import ci.net.demo1.models.HibernateConnection;
import ci.net.demo1.models.entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RoleRepo implements Repo<Role> {
    @Override
    public void create(Role role) throws SQLException {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(role);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Role getById(Long roleId) {
        Transaction tx = null;
        Role role = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            role = session.get(Role.class, roleId);
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        Transaction tx = null;
        List<Role> roles = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            roles = session.createQuery("from Role", Role.class).list();
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            session.delete(role);
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
    public void update(Role role) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            // start a tx
            tx = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(role);
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
}
