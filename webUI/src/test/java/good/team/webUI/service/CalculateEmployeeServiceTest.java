package good.team.webUI.service;

import good.team.webUI.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


class CalculateEmployeeServiceTest {

    @Mock
    EmployeeServiceApi employeeServiceApiMock;

    @BeforeEach
    void initMock() {
        MockitoAnnotations.initMocks(this);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("vova", "gtty", 30));
        employees.add(new Employee("vova", "gtty", 40));
        employees.add(new Employee("vova", "gtty", 50));
        Mockito.when(employeeServiceApiMock.getEmployeeList()).thenReturn(employees);
        Mockito.when(employeeServiceApiMock.getEmployeeById(any())).thenReturn(new Employee(4,"Vova", "gtty", 40));

    }

    @Test
    void getEmployeeNameUpperCasedByIdTest() {
        CalculateEmployeeSalaryService calculateEmployeeSalaryService = new CalculateEmployeeSalaryService();
        calculateEmployeeSalaryService.employeeServiceApi = employeeServiceApiMock;
        String resultName = calculateEmployeeSalaryService.getEmployeeNameUpperCasedById("1500");
        Mockito.verify(employeeServiceApiMock).getEmployeeById(any());
        if (!(resultName != null && resultName.length() > 0)) {
            Assertions.fail("ALARM!");
        }
        String exept = "GTTY";
        String real = resultName;

            Assertions.assertEquals(exept,real);


    }


    @Test
    void avgOfAgeTest() {
//        List<Employee> employees = new ArrayList<Employee>();
//        employees.add(new Employee("vova","gtty",30));
//        employees.add(new Employee("vova","gtty",40));
//        employees.add(new Employee("vova","gtty",50));

//        EmployeeServiceApi employeeServiceApiMock = Mockito.mock(EmployeeServiceApi.class);
        //  Mockito.when(employeeServiceApiMock.getEmployeeList()).thenReturn(employees);
        CalculateEmployeeSalaryService calculateEmployeeSalaryService = new CalculateEmployeeSalaryService();
        calculateEmployeeSalaryService.employeeServiceApi = employeeServiceApiMock;
        int avgAge = calculateEmployeeSalaryService.avgOfAge();

        if (avgAge <= 0) {
            Assertions.fail("fail test");

        }
    }
}
