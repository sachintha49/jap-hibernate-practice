package lk.ijse.dep7;

import lk.ijse.dep7.entity.Student;
import lk.ijse.dep7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateDemo1 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student sachintha = session.find(Student.class, 2);
            System.out.println(sachintha);
            sachintha.setContactNumber("0772622642");
            session.getTransaction().commit();
            System.out.println(sachintha);
        }
    }
}
