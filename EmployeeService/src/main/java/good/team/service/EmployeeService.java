package good.team.service;

import good.team.dao.EmployeeDao;
import good.team.dao.EmployeeJdbcDao;
import good.team.entity.Employee;

import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao = new EmployeeJdbcDao();
    EmployeeJdbcDao employeeJdbcDao = new EmployeeJdbcDao();


    public Employee getEmployeeById(String id){


        try {
            int id1 = Integer.parseInt(id);
            employeeJdbcDao.getEmployeeByIdJdbc(id1);
        }
        catch (Exception e) {
            System.out.println("You enter wrong data");
            e.printStackTrace();
        }


        return null;
    }


    public void updatePersonById(int id, String lastName, String firstName, int age) {
        String lastNameSQL = "`lastName` = ' " + lastName + "'";
        String firstNameSQL = "`firstName` = '" + firstName + "'";
        String AgeSQL = "`age` = '" + age + "'";
        char z = ',';

        if (lastName.length() < 1) {
            lastNameSQL = " ";
        }
        if (firstName.length() < 1) {
            firstNameSQL = " ";
        }
        if (age == 0) {
            AgeSQL = " ";
        }
        if (lastNameSQL.length() > 2 & (firstNameSQL.length() > 2 | AgeSQL.length() > 2)) {
            lastNameSQL = lastNameSQL + z;
        }if ( firstNameSQL.length() > 2 & AgeSQL.length() > 2) {
            firstNameSQL = firstNameSQL + z;
        }

        new EmployeeJdbcDao().updateEmployeeSQLById(id, lastNameSQL, firstNameSQL, AgeSQL);
    }

    public void updatePersonById(Employee employee) {
        new EmployeeService().updatePersonById(employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getAge());
    }
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeDao.getAllEmployee();
        return employees;
    }
}