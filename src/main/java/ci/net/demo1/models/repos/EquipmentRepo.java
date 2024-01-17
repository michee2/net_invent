package ci.net.demo1.models.repos;



import ci.net.demo1.models.HibernateConnection;
import ci.net.demo1.models.entities.Equipment;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public class EquipmentRepo implements Repo<Equipment> {
    @Override
    public void create(Equipment equipement) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            session.save(equipement);
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Equipment getById(Long equipementId) {
        Transaction tx = null;
        Equipment equipement = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            equipement = session.get(Equipment.class, equipementId);
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return equipement;
    }

    @Override
    public List<Equipment> getAll() {
        Transaction tx = null;
        List<Equipment> equipements = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            equipements = session.createQuery("from Equipment", Equipment.class).list();
            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return equipements;
    }

    @Override
    public boolean delete(Equipment equipement) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            session.delete(equipement);
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
    public void update(Equipment equipement) throws SQLException {
        Transaction tx = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            // start a tx
            tx = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(equipement);
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

    public List<Equipment> getAllFaulty() {
        Transaction tx = null;
        List<Equipment> equipements_faulty = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            equipements_faulty = session.createQuery("from Equipment e WHERE e.status = :status", Equipment.class)
                    .setParameter("status", "Mauvais")
                    .getResultList();

            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return equipements_faulty;
    }

    public List<Equipment> getAllRouters() {
        Transaction tx = null;
        List<Equipment> routers = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            routers = session.createQuery("from Equipment e WHERE e.type = :type", Equipment.class)
                    .setParameter("type", "Router")
                    .getResultList();

            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return routers;
    }

    public List<Equipment> getAllSwitches() {
        Transaction tx = null;
        List<Equipment> switchs = null;
        SessionFactory factory = HibernateConnection.getSessionFactory();
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();
            switchs = session.createQuery("from Equipment e WHERE e.type = :type", Equipment.class)
                    .setParameter("type", "Switch")
                    .getResultList();

            tx.commit();

            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return switchs;
    }
}

