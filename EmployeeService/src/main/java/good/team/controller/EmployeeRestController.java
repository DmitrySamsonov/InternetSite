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
            employeeService.createEmployee(employeeLastName, employeeFirstName, employeeAge);
            List<Employee> employees = employeeService.getAllEmployee();
            model.addAttribute("employeeList", employees);
            return "employees";
        } catch (RuntimeException e) {
            return "createPerson";
        }
    }

    @GetMapping
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new EmployeeService().getAllEmployee();
        return employeeList;
    }

    @PutMapping
    public String updateEmployee(ModelMap model,
                                 @RequestParam(name = "updateEmployeeId") String updateEmployeeId,
                                 @RequestParam(name = "updateEmployeeLastName") String updateEmployeeLastName,
                                 @RequestParam(name = "updateEmployeeFirstName") String updateEmployeeFirstName,
                                 @RequestParam(name = "updateEmployeeAge") String updateEmployeeAge) {
        try {
            employeeService.updateEmployee(updateEmployeeId, updateEmployeeLastName, updateEmployeeFirstName, updateEmployeeAge);
            List<Employee> employees = employeeService.getAllEmployee();
            model.addAttribute("employeeList", employees);
            return "employees";
        } catch (RuntimeException e) {
            return "createPerson";
        }
    }

    @GetMapping("/{id}")
    public Employee employeeById(@PathVariable(name = "id") String id) {
        Employee employeeById = new EmployeeService().getEmployeeById(id);
        return employeeById;
    }
}