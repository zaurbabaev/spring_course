package az.zaurbabayev.spring_introduction;

import org.springframework.beans.factory.annotation.Value;

//@Component
public class Person {
//    @Autowired
//    @Qualifier("catBean")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        System.out.println("Class Person set surname");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("Class Person set age");
    }
//    @Autowired
//
    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }


    public Person() {
        System.out.println("Person bean is created");
    }

//    @Autowired
//    @Qualifier("catBean")
    public void setPet(Pet pet) {
        System.out.println("Class person: set pet");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
