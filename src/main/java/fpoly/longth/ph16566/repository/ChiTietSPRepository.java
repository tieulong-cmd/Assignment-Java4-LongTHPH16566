package fpoly.longth.ph16566.repository;

import fpoly.longth.ph16566.entity.ChiTietSP;
import fpoly.longth.ph16566.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ChiTietSPRepository {
    public List<ChiTietSP> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<ChiTietSP> query = session.createQuery("FROM ChiTietSP", ChiTietSP.class);
            return query.list();
        }
    }

    public Boolean add(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean remove(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public ChiTietSP getOne(String idParam) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<ChiTietSP> query = session.createQuery("FROM ChiTietSP WHERE id = :idGetOne", ChiTietSP.class);
            query.setParameter("idGetOne", idParam);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
