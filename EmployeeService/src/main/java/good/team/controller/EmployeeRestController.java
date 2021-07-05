package good.team.controller;

import good.team.entity.Employee;
import good.team.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeRestController {
    @RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)
    public ModelMap getEmployeeList(ModelMap model) {

        List<Employee> employeeList = new EmployeeService().getAllEmployee();
        model.addAttribute("getEmployeeList", employeeList);

        return model;
    }
}