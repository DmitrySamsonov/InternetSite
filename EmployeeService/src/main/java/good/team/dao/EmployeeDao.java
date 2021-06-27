package good.team.dao;

import good.team.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployee();

    void updateEmployeeById(int id, String lastName, String firstName, int age);
}
