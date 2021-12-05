package homework_30.DAO;

import homework_30.HibernateUtil;
import homework_30.entity.StudentGroup;
import org.hibernate.Session;

import java.util.List;

public class StudentGroupDAO {
    public StudentGroup get(Integer id) {
        StudentGroup result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.get(StudentGroup.class, id);
        }
        return result;
    }

    public List<StudentGroup> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT gr FROM StudentGroup gr";
            return session.createQuery(sql, StudentGroup.class).getResultList();
        }
    }

    public StudentGroup saveOrUpdate(StudentGroup studentGroup) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(studentGroup);
            session.getTransaction().commit();
        }
        return studentGroup;
    }
}
