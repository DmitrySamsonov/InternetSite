package good.team.service;

import good.team.dao.EmployeeDao;
import good.team.dao.EmployeeJdbcDao;
import good.team.entity.Employee;
import good.team.exception.EmployeeWebException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public static final String REG_EXP_LETTERS = "[A-Za-z]*";

    EmployeeDao employeeDao = new EmployeeJdbcDao();
    EmployeeJdbcDao employeeJdbcDao = new EmployeeJdbcDao();


    public Employee getEmployeeById(String id) {


        try {
            int id1 = Integer.parseInt(id);
            employeeJdbcDao.getEmployeeByIdJdbc(id1);
        } catch (Exception e) {
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
        }
        if (firstNameSQL.length() > 2 & AgeSQL.length() > 2) {
            firstNameSQL = firstNameSQL + z;
        }
        new EmployeeJdbcDao().updateEmployeeSQLById(id, lastNameSQL, firstNameSQL, AgeSQL);
    }

    public void updatePersonById(Employee employee) {
        new EmployeeService().updatePersonById(employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getAge());
    }


    public void createEmployee(String employeeLastName, String employeeFirstName, String employeeAge) {
    }


    public void updateEmployee(String updateEmployeeIdString, String updateLastName, String updateFirstName, String
            updateEmployeeAgeString) {
        ArrayList<String> errorList = new ArrayList<>();

        if (updateLastName != null && updateFirstName != null && updateEmployeeAgeString != null) {
            if (updateLastName.length() < 3 || updateLastName.length() > 15) {
                String message = "employeeLastName not in range in 2-15";
                errorList.add(message);
            }

            if (updateFirstName.length() < 3 || updateFirstName.length() > 15) {
                String message = "employeeFirstName not in range in 2-15";
                errorList.add(message);
            }

            if (!updateLastName.matches(REG_EXP_LETTERS)) {
                String message = "updateLastName has no correct symbols";
                errorList.add(message);
            }

            if (!updateFirstName.matches(REG_EXP_LETTERS)) {
                String message = "updateFirstName has no correct symbols";
                errorList.add(message);
            }

            int updateEmployeeAge = 0;
            try {
                updateEmployeeAge = Integer.parseInt(updateEmployeeAgeString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (updateEmployeeAge < 0) {
                String message = "updateEmployeeAge cannot be negative";
                errorList.add(message);
            }

            int updateEmployeeId = 0;
            try {
                updateEmployeeId = Integer.parseInt(updateEmployeeIdString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (updateEmployeeId < 0) {
                String message = "updateEmployeeId cannot be negative";
                errorList.add(message);
            }

            if (errorList.size() > 0) {
                throw new EmployeeWebException(errorList);
            }

            employeeDao.updateEmployeeById(updateEmployeeId, updateLastName, updateFirstName, updateEmployeeAge);
        }
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeDao.getAllEmployee();
        return employees;
    }
}