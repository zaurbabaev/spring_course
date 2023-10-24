package az.zaurbabayev.hibernate_test.crud_operations;

import az.zaurbabayev.hibernate_test.crud_operations.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Elena", "Petrova", "Sales", 800);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            int myInt = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myInt);
            session.getTransaction().commit();

            System.out.println(employee);
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
