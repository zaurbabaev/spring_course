package az.zaurbabayev.hibernate_test.one_to_many_bi_loading_types;

import az.zaurbabayev.hibernate_test.one_to_many_bi_loading_types.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Department department = new Department("IT", 800, 1500);
            Employee emp1 = new Employee("Zaur", "Tregulov", 1500);
            Employee emp2 = new Employee("Mariya", "Memmedova", 1000);
            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
