package az.zaurbabayev.hibernate_test.crud_operations;

import az.zaurbabayev.hibernate_test.crud_operations.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> employee = session.createQuery("from Employee" +
                            "where name='Aleksandr' AND salary>1000")
                    .getResultList();
            session.getTransaction().commit();

            for (Employee e : employee) {
                System.out.println(e);
            }

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }


}


