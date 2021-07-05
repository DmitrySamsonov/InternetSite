package good.team.controller;

import good.team.entity.Employee;
import good.team.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping
    public String createEmployee(ModelMap model,
                          @RequestParam(name = "employeeLastName") String employeeLastName,
                          @RequestParam(name = "employeeFirstName") String employeeFirstName,
                          @RequestParam(name = "employeeAge") String employeeAge) {
        try {
            employeeService.createEmployee(employeeLastName, employeeFirstName,employeeAge);
            List<Employee> employees = employeeService.getAllEmployee();
            model.addAttribute("employeeList", employees);
            return "employees";
        } catch (RuntimeException e) {
            return "createPerson";
        }
    }

}