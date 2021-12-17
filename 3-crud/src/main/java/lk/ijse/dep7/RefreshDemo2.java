package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo2 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            // hibernate thinks this is in detache state but this really in new state
            // mokada ekata hethuwa api me entity ekata ID ekak specify karapu eka
            // mokdaa eya hema welema hithanne ah meyata primary key ekak specify karala thiyanawane eka nisa meya alaready DB eke inawa recod ekak kiyala
            // api primary eka damme neththam eya hitha gannawa ehenam new state eke thama inna one kiyala
            /*Student student = new Student(1, "Aruni", "Matara", "09903394");*/
            Student student = session.get(Student.class, 1);
            session.evict(student);
            System.out.println("Student has been detached");
            System.out.println("Is the student inside the cache? "+session.contains(student));
            session.refresh(student);
            System.out.println("Student has been refreshed");
            System.out.println("Is the student inside the cache? "+session.contains(student));

            session.getTransaction().commit();
        }
    }
}
