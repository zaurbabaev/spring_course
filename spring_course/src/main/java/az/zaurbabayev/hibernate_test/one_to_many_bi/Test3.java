package az.zaurbabayev.hibernate_test.one_to_many_bi;

import az.zaurbabayev.hibernate_test.one_to_many_bi.entity.Department;
import az.zaurbabayev.hibernate_test.one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
