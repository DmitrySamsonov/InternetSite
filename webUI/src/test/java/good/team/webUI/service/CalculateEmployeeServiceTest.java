package good.team.webUI.service;

import good.team.webUI.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

class CalculateEmployeeServiceTest {
    @Mock
    EmployeeServiceApi employeeServiceApiMock;


    @BeforeEach
    void initMock() {
        MockitoAnnotations.initMocks(this);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "a", "a", 30));
        employees.add(new Employee(1, "b", "b", 40));
        employees.add(new Employee(1, "c", "c", 50));
        Mockito.when(employeeServiceApiMock.getEmployeeList()).thenReturn(employees);
        Employee employee = new Employee(2147483647,"test","Mockito",2);
        Mockito.when(employeeServiceApiMock.getEmployeeById(any())).thenReturn(employee);
        Mockito.when(employeeServiceApiMock.getEmployeeById("-1")).thenThrow(Exception.class);

    }
    @Test
    void avgOfAge() {

//        ArrayList<Employee> employees = new ArrayList<Employee>();
//        employees.add(new Employee(1, "a", "a", 30));
//        employees.add(new Employee(1, "b", "b", 40));
//        employees.add(new Employee(1, "c", "c", 50));

//        EmployeeServiceApi employeeServiceApiMock = Mockito.mock(EmployeeServiceApi.class);

//        Mockito.when(employeeServiceApiMock.getEmployeeList()).thenReturn(employees);
        CalculateEmployeeService calculateEmployeeService = new CalculateEmployeeService();
        calculateEmployeeService.employeeServiceApi = employeeServiceApiMock;

        int avgAge = calculateEmployeeService.avgOfAge();

        if (avgAge <= 0) {
            Assertions.fail("fail test");
        }

    }

    @Test
    void getEmpoyeeNameUpperCasedById() {
        CalculateEmployeeService calculateEmployeeService = new CalculateEmployeeService();
        calculateEmployeeService.employeeServiceApi = employeeServiceApiMock;
        String resultName = calculateEmployeeService.getEmpoyeeNameUpperCasedById("100");

        Mockito.verify(employeeServiceApiMock).getEmployeeById(any());
        if (!(resultName!=null && resultName.length()>0)){
            Assertions.fail("fatal test");

        }

        String expected = "TEST";
        String actual = resultName;
        Assertions.assertEquals(expected, actual);
    }

}