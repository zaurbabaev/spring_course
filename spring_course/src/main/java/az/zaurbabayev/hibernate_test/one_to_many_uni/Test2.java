package az.zaurbabayev.hibernate_test.one_to_many_uni;

import az.zaurbabayev.hibernate_test.one_to_many_uni.entity.Department;
import az.zaurbabayev.hibernate_test.one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Department department = session.get(Department.class, 5);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }

}
