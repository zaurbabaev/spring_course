package az.zaurbabayev.spring.mvc;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    private String name;
    private String surname;
    private int salary;
    private String department;

    private Map<String, String> departments;

    private String carBrand;

    private Map<String,String> carBrandList;

    private String [] languages;

    private Map<String,String> languageList;



    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public Employee() {
        departments=new HashMap<>();
        departments.put("Information Technology","IT");
        departments.put("Sales","Sales");
        departments.put("Human Resources","HR");


        carBrandList=new HashMap<>();
        carBrandList.put("BMW","BMW");
        carBrandList.put("Audi","Audi");
        carBrandList.put("Mercedes-Benz","MB");

        languageList=new HashMap<>();
        languageList.put("English","En");
        languageList.put("French","Fr");
        languageList.put("Russian","Ru");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrandList() {
        return carBrandList;
    }

    public void setCarBrandList(Map<String, String> carBrandList) {
        this.carBrandList = carBrandList;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
