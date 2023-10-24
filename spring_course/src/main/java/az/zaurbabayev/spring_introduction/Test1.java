package az.zaurbabayev.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = contex.getBean("myPet", Pet.class);
        pet.say();
        contex.close();
    }
}
