package good.team.webUI.service;

import good.team.webUI.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceApi {

    public Employee getEmployeeById(String id) {
        if (("3").equals(id)) {
            return new Employee(3, "Goga", "Abhadze", 54);
        }
        return null;
    }

    public List<Employee> getEmployeeList() {


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee[]> response = null;
        try {
            response = restTemplate.getForEntity(
                    "http://localhost:8089/EmployeeService/employee",
                    Employee[].class);
            Employee[] employee = response.getBody();

            List<Employee> employees = Arrays.asList(employee);
            return employees;
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }


}
