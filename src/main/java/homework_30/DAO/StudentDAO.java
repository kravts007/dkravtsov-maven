package homework_30.DAO;

import homework_30.HibernateUtil;
import homework_30.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO {
    public Student get(Integer id) {
        Student result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.get(Student.class, id);
        }
        return result;
    }

    public Student saveOrUpdate(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
        return student;
    }

    public List<Student> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT a FROM Student a";
            return session.createQuery(sql, Student.class).getResultList();
        }
    }

    public List<Student> findByNameContaining(String partOfFullName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String partOfName = "%" + partOfFullName + "%";
            String sql = "SELECT a FROM Student a WHERE a.fio LIKE: partOfName";
            return session.createQuery(sql, Student.class).setParameter("partOfName", partOfName).getResultList();
        }
    }
}
