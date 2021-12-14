package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HelloHibernateDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student dulanga = new Student(1, "Dulanga", "Matale", "077-3447384");
            session.save(dulanga);
            session.getTransaction().commit();
        }
    }
}
