package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class persistDemoJPA {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student sachi = new Student(2, "Sachintha", "Kottawa", "077-2622642");
            session.persist(sachi);
            session.getTransaction().commit();
        }
    }
}
