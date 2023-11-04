package az.zaurbabayev.spring.rest;

import az.zaurbabayev.spring.rest.configuration.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> employees = communication.getAllEmployees();
//        employees.forEach(System.out::println);

//        Employee employee = communication.getEmployee(11);
//        System.out.println(employee);
//        Employee employee = new Employee("Hesen", "Hesenov", "İT", 1200);
//        employee.setId(20);
//        communication.saveEmployee(employee);
        communication.deleteEmployee(20);
    }
}
