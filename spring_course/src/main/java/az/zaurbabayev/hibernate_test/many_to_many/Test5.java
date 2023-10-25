package az.zaurbabayev.hibernate_test.many_to_many;

import az.zaurbabayev.hibernate_test.many_to_many.entity.Child;
import az.zaurbabayev.hibernate_test.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Section section = new Section("Dance");
            Child child1 = new Child("Yusif", 6);
            Child child2 = new Child("Kamal", 8);
            Child child3 = new Child("Alesha", 5);
            section.addchildToSection(child1);
            section.addchildToSection(child2);
            section.addchildToSection(child3);
            session.beginTransaction();
            session.persist(section);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        } finally {
            session.close();
            factory.close();
        }
    }


}
