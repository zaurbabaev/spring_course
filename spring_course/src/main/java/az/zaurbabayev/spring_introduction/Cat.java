package az.zaurbabayev.spring_introduction;

//@Component("catBean")
public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("Myau-myau");
    }
}
