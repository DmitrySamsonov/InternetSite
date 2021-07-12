package good.team.webUI.service;

import good.team.webUI.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceApiTest {

    @Test
    void getEmployeeList() {
     //   EmployeeServiceApi employeeServiceApi = new EmployeeServiceApi();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("vova","gtty",30));
        employees.add(new Employee("vova","gtty",40));
        employees.add(new Employee("vova","gtty",50));

        EmployeeServiceApi employeeServiceApiMock = Mockito.mock(EmployeeServiceApi.class);
        Mockito.when(employeeServiceApiMock.getEmployeeList()).thenReturn(employees);

        List<Employee> employeeList = employeeServiceApiMock.getEmployeeList();
        if ( !(employeeList !=null && employeeList.size() > 0)) {
            Assertions.fail("fail>0");
        }
        System.out.println("!!");
    }
}