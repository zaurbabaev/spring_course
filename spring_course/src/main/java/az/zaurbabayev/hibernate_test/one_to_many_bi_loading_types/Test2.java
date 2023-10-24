package az.zaurbabayev.hibernate_test.one_to_many_bi_loading_types;

import az.zaurbabayev.hibernate_test.one_to_many_bi_loading_types.entity.Department;
import az.zaurbabayev.hibernate_test.one_to_many_bi_loading_types.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
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
            System.out.println("Get departments");
            Department department=session.get(Department.class,7);
            System.out.println("Show department");
            System.out.println(department);
            department.getEmps().get(0);
            session.getTransaction().commit();
            System.out.println("Show employees");
            System.out.println(department.getEmps());

            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
