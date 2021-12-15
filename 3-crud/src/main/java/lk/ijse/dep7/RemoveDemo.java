package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Student student = session.get(Student.class, 2);
            System.out.println("Is Student inside the context? "+session.contains(student));
            session.remove(student);
            System.out.println("Is Student inside the context? "+session.contains(student));


            session.getTransaction().commit();
        }
    }
}
