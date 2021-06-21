package my.app.dao;

import my.app.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void createEmployee(Employee employee);

    void deleteEmployeeById(int id);

    void updateEmployee(Employee employee);

    Employee readEmployeeById(int id);

    List<Employee> readAllEmployees();


}
