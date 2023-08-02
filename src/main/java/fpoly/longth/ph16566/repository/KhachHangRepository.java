package fpoly.longth.ph16566.repository;

import fpoly.longth.ph16566.entity.KhachHang;
import fpoly.longth.ph16566.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class KhachHangRepository {
    public List<KhachHang> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<KhachHang> query = session.createQuery("FROM KhachHang", KhachHang.class);
            return query.list();
        }
    }

    public KhachHang getOne(String idParam) {
        KhachHang khachHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang WHERE id =: idGetOne", KhachHang.class);
            query.setParameter("idGetOne", idParam);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public List<KhachHang> filterByName(String tenParam) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<KhachHang> query = session.createQuery("FROM KhachHang WHERE ten LIKE: tenSearch", KhachHang.class);
            query.setParameter("tenSearch", "%" + tenParam + "%");
            return query.list();
        }
    }

    public Boolean remove(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean add(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
}
