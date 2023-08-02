package fpoly.longth.ph16566.repository;

import fpoly.longth.ph16566.entity.NhanVien;
import fpoly.longth.ph16566.service.NhanVienService;
import fpoly.longth.ph16566.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NhanVienRepository implements NhanVienService {
    @Override
    public List<NhanVien> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<NhanVien> query = session.createQuery("FROM NhanVien", NhanVien.class);
            return query.list();
        }
    }

    @Override
    public Boolean add(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean remove(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<NhanVien> searchName(String tenParam) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<NhanVien> query = session.createQuery("FROM NhanVien WHERE ten LIKE: tenSearch", NhanVien.class);
            query.setParameter("tenSearch", "%" + tenParam + "%");
            return query.list();
        }
    }

    @Override
    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;

    }

    @Override
    public NhanVien getOne(String idParam) {

        NhanVien nhanVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE id =: idGetOne", NhanVien.class);
            query.setParameter("idGetOne", idParam);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }
}
