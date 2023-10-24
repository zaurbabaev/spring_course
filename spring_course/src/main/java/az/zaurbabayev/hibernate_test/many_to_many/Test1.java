package az.zaurbabayev.hibernate_test.many_to_many;

import az.zaurbabayev.hibernate_test.many_to_many.entity.Child;
import az.zaurbabayev.hibernate_test.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Child child = new Child("Aleksey", 12);
            Section section1 = new Section("Math");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Dance");
            child.addSectionToChild(section1);
            child.addSectionToChild(section2);
            child.addSectionToChild(section3);
            session.beginTransaction();
            session.save(child);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        } finally {
            session.close();
            factory.close();
        }
    }


}
