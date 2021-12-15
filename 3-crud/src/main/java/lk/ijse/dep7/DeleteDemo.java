package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Student student = session.get(Student.class, 1);
            System.out.println("Is Student inside the context? "+session.contains(student));
            session.delete(student);
            System.out.println("Is Student inside the context? "+session.contains(student));


            session.getTransaction().commit();
        }
    }
}
