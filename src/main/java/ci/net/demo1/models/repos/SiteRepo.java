package ci.net.demo1.models.repos;

import ci.net.demo1.models.HibernateConnection;
import ci.net.demo1.models.entities.Site;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class SiteRepo implements Repo<Site> {
    @Override
    public void create(Site site) throws SQLException {
        Transaction transaction = null;
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(site);
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
    public Site getById(Long siteId) {
        Transaction tx = null;
        Site site = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            site = session.get(Site.class, siteId);
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return site;
    }

    @Override
    public List<Site> getAll() {
        Transaction tx = null;
        List<Site> sites = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            sites = session.createQuery("from Site", Site.class).list();
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public boolean delete(Site site) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            session.delete(site);
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
    public void update(Site site) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            // start a tx
            tx = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(site);
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
