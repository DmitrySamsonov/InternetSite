package good.team.service;

import good.team.dao.EmployeeDao;
import good.team.dao.EmployeeJdbcDao;
import good.team.entity.Employee;

import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao = new EmployeeJdbcDao();

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeDao.getAllEmployee();
        return employees;
    }

}
