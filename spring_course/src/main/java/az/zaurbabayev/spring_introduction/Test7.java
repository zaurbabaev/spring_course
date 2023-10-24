package az.zaurbabayev.spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
//        Pet myCat = context.getBean("catBean", Pet.class);
//        myCat.say();
        Person person=context.getBean("personBean",Person.class);

        context.close();
    }
}
