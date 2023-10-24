package az.zaurbabayev.hibernate_test.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Section section = new Section("Football");
            Child child1 = new Child("Zaur", 5);
            Child child2 = new Child("Vusal", 6);
            Child child3 = new Child("Mais", 8);
            section.addchildToSection(child1);
            section.addchildToSection(child2);
            section.addchildToSection(child3);
            session.beginTransaction();
            session.save(section);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }


}
