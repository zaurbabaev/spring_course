package az.zaurbabayev.hibernate_test.one_to_many_uni;

import az.zaurbabayev.hibernate_test.one_to_many_uni.entity.Department;
import az.zaurbabayev.hibernate_test.one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Department department = new Department("IT", 300, 1200);
            Employee emp1 = new Employee("Zaur", "Trequlov", 800);
            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
            department.addEployeeToDepartment(emp1);
            department.addEployeeToDepartment(emp2);
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }

}
