package good.team.webUI.controller;

import good.team.webUI.entity.Employee;
import good.team.webUI.service.EmployeeServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeInfoController {

    @Autowired
    EmployeeServiceApi employeeServiceApi;


    @GetMapping("/get")
    public String getById(Model model) {
        System.out.println();
        List<Employee> employeeList = employeeServiceApi.getEmployeeList();
        System.out.println();
        return "greeting";
    }
}
