package az.zaurbabayev.spring.springboot.springboot_rest_jpa.service;


import az.zaurbabayev.spring.springboot.springboot_rest_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
}
