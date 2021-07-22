package good.team.webUI.service;

import good.team.webUI.entity.Employee;

import java.util.List;

public class CalculateEmployeeService {

    EmployeeServiceApi employeeServiceApi = new EmployeeServiceApi();

    public int avgOfAge() {
        List<Employee> employeeList = employeeServiceApi.getEmployeeList();
        int ageCount = 0;
        int result = 0;
        if (employeeList != null) {
            for (Employee employee : employeeList) {
                ageCount += employee.getAge();
            }
            result = ageCount / employeeList.size();
        }
        return result;
    }

    public String getEmpoyeeNameUpperCasedById(String id) {

        if(id.length() > 2){    //"115"
            Employee employee = employeeServiceApi.getEmployeeById(id);
            if (employee != null) {
                String nameToUpperCose = employee.getLastName().toUpperCase();
                return nameToUpperCose;
            }
        }
        return null;
    }


}
