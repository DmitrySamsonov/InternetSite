package good.team.webUI.service;

import good.team.webUI.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class EmployeeServiceApiTest {

    @Test
    void getEmployeeList() {

//        EmployeeServiceApi employeeServiceApi = new EmployeeServiceApi();
        EmployeeServiceApi employeeServiceApiMock = Mockito.mock(EmployeeServiceApi.class);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());

        Mockito.when(employeeServiceApiMock.getEmployeeList()).thenReturn(employees);

        List<Employee> employeeList = employeeServiceApiMock.getEmployeeList();

        if (!(employeeList != null && employeeList.size() > 0)) {
            Assertions.fail("fail test");
        }
        System.out.println("test good");
    }
}