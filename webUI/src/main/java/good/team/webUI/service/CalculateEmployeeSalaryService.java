package good.team.webUI.service;

import good.team.webUI.entity.Employee;
import good.team.webUI.service.EmployeeServiceApi;

import java.util.List;

public class CalculateEmployeeSalaryService {
    EmployeeServiceApi employeeServiceApi = new EmployeeServiceApi();


    public String getEmployeeNameUpperCasedById(String id) {
        if (id.length() > 2) {   // добавка условия на ид больше 100

            Employee employeeById = employeeServiceApi.getEmployeeById(id);
            if (employeeById != null) {
                String nameToUpperCase = employeeById.getFirstName().toUpperCase();
                return nameToUpperCase;
            }
        }
        return null;
    }


    public int avgOfAge() {

        //  EmployeeServiceApi employeeServiceApi = new EmployeeServiceApi();
        List<Employee> employeeList = employeeServiceApi.getEmployeeList();
        int ageCount = 0;
        int result = 0;
        if (employeeList != null) {
            for (Employee emp : employeeList) {
                ageCount += emp.getAge();
            }
            result = ageCount / employeeList.size();

        }
        return result;
    }
}

