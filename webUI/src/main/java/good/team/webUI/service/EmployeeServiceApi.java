package good.team.webUI.service;

import good.team.webUI.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceApi {

    public Employee getEmployeeById(String id) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee[]> response = null;
        try {
            response = restTemplate.getForEntity(
                    "http://localhost:8089/EmployeeService/employee",
                    Employee[].class);
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Employee[] employee = response.getBody();
        return employee[0];

    }


}
