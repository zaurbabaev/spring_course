package az.zaurbabayev.spring.springboot.springboot_rest_jpa.service;

import az.zaurbabayev.spring.springboot.springboot_rest_jpa.dao.EmployeeDAO;
import az.zaurbabayev.spring.springboot.springboot_rest_jpa.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        return allEmployees;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);

    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
