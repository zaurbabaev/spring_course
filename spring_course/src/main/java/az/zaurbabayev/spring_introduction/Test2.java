package az.zaurbabayev.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
//        Pet pet=new Cat();
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person myPerson = context.getBean("myPerson", Person.class);
        myPerson.callYourPet();
        System.out.println( myPerson.getAge());
        System.out.println( myPerson.getSurname());;
        context.close();
    }
}
