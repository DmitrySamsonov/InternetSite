package good.team.service;

import good.team.dao.EmployeeDao;
import good.team.dao.EmployeeJdbcDao;
import good.team.entity.Employee;

import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao = new EmployeeJdbcDao();


    public void updatePersonById(int id, String lastName, String firstName, String ageString) {

        if (ageString == null) {
            new EmployeeJdbcDao().updateEmployeeNameById(id, lastName, firstName);
        } else {
            int age = Integer.parseInt(ageString);
            new EmployeeJdbcDao().updateEmployeeById(id, lastName, firstName, age);
        }
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeDao.getAllEmployee();
        return employees;
    }
}
