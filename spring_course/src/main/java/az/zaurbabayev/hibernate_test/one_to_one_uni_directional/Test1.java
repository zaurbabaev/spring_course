package az.zaurbabayev.hibernate_test.one_to_one_uni_directional;

import az.zaurbabayev.hibernate_test.one_to_one_uni_directional.entity.Detail;
import az.zaurbabayev.hibernate_test.one_to_one_uni_directional.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
            Detail detail = new Detail("Moscow", "1234693", "oleshka@Gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            session.save(employee);
            System.out.println("Done!");

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}