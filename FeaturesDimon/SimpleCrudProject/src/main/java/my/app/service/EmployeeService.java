package my.app.service;

import my.app.dao.EmployeeDao;
import my.app.dao.EmployeeJdbcDao;
import my.app.entity.Employee;
import my.app.exception.EmployeeWebException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao;
    public static final String REG_EXP_LETTERS = "[A-Za-z]*";

    public EmployeeService() {
        employeeDao = new EmployeeJdbcDao();
        //personDao = new personJdbcDao();
    }

    public void createNewEmployee(Employee employee) {
        new EmployeeJdbcDao().createEmployee(employee);
    }


    public List<Employee> readAllEmployees() {
        List<Employee> people = employeeDao.readAllEmployees();
        return people;
    }


    public void updateEmployeeById(String employeeIdString, String employeeName, String employeeAgeString) throws EmployeeWebException {
        ArrayList<String> errorList = new ArrayList<>();

        if (employeeName != null && employeeAgeString != null) {
            if (employeeName.length() < 3 || employeeName.length() > 15) {
                String message = "employeeName not in range in 2-15";
                errorList.add(message);
            }
            if (!employeeName.matches(REG_EXP_LETTERS)) {
                String message = "employeeName has no correct symbols";
                errorList.add(message);
            }

            int employeeAge = 0;
            try {
                employeeAge = Integer.parseInt(employeeAgeString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (employeeAge < 0) {
                String message = "age cannot be negative";
                errorList.add(message);
            }

            int employeeId = 0;
            try {
                employeeId = Integer.parseInt(employeeIdString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (employeeId < 0) {
                String message = "id cannot be negative";
                errorList.add(message);
            }


            if (errorList.size() > 0) {
                throw new EmployeeWebException(errorList);
            }

            Employee employee = new Employee(employeeId, employeeName, employeeAge);
            employeeDao.updateEmployee(employee);

        }
    }

    public void deleteEmployeeById(int id) {
        ArrayList<String> errorList = new ArrayList<>();

        if (id < 0) {
            String message = "id deleted employee cannot be negative";
            errorList.add(message);
        }

        if (errorList.size() > 0) {
            throw new EmployeeWebException(errorList);
        }
        employeeDao.deleteEmployeeById(id);

    }

    public void createEmployee(String employeeName, String employeeAgeString) throws EmployeeWebException {
        ArrayList<String> errorList = new ArrayList<>();

        if (employeeName != null && employeeAgeString != null) {
            if (employeeName.length() < 3 || employeeName.length() > 15) {
                String message = "employeeName not in range in 2-15";
                errorList.add(message);
            }
            if (!employeeName.matches(REG_EXP_LETTERS)) {
                String message = "employeeName has no correct symbols";
                errorList.add(message);
            }

            int employeeAge = 0;
            try {
                employeeAge = Integer.parseInt(employeeAgeString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (employeeAge < 0) {
                String message = "age cannot be negative";
                errorList.add(message);
            }

            if (errorList.size() > 0) {
                throw new EmployeeWebException(errorList);
            }

            Employee employee = new Employee(employeeName,employeeAge);
            createEmployee(employee);
        }
    }

    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

}
