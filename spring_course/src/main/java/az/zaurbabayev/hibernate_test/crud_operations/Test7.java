package az.zaurbabayev.hibernate_test.crud_operations;

import az.zaurbabayev.hibernate_test.crud_operations.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test7 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 5);
            employee.setSalary(3000);
            session.getTransaction().commit();


            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }


}


