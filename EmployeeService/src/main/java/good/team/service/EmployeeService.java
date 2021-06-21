package good.team.service;

import good.team.dao.EmployeeDao;
import good.team.entity.Employee;

import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao;

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeDao.getAllEmployee();
        return employees;
    }

}
