package az.zaurbabayev.hibernate_test.one_to_one_bi_directional;

import az.zaurbabayev.hibernate_test.one_to_one_bi_directional.entity.Detail;
import az.zaurbabayev.hibernate_test.one_to_one_bi_directional.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee employee = new Employee("Kamal", "Nuri", "Sales", 800);
            Detail detail = new Detail("Baki", "4576732", "kamil@mail.ru");
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(detail);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }

}
