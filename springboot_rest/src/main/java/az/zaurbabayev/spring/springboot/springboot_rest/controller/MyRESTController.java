package az.zaurbabayev.spring.springboot.springboot_rest.controller;

import az.zaurbabayev.spring.springboot.springboot_rest.entity.Employee;
import az.zaurbabayev.spring.springboot.springboot_rest.exception_handling.NoSuchEmployeeException;
import az.zaurbabayev.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + "in database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee==null){
        throw new NoSuchEmployeeException("There is no employee with ID = " + id +
                " in database");
        }
        else{
            employeeService.deleteEmployee(id);
            return "Employee with ID = "+id+" was deleted";
        }

    }

}
