package az.zaurbabayev.hibernate_test.one_to_many_bi;

import az.zaurbabayev.hibernate_test.one_to_many_bi.entity.Department;
import az.zaurbabayev.hibernate_test.one_to_many_bi.entity.Employee;
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
            Department department = new Department("Sales", 2000, 1200);
            Employee emp1 = new Employee("Sonya", "Salayeva", 1500);
            Employee emp2 = new Employee("Mariya", "Memmedova", 1800);
            department.addEployeeToDepartment(emp1);
            department.addEployeeToDepartment(emp2);
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
