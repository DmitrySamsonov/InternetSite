package good.team.service;

import good.team.dao.EmployeeJdbcDao;

public class EmployeeService {
    public void updatePersonById(int id, String lastName, String firstName, String ageString) {

        if (ageString == null) {
            new EmployeeJdbcDao().updateEmployeeNameById(id, lastName, firstName);
        } else {
            int age = Integer.parseInt(ageString);
            new EmployeeJdbcDao().updateEmployeeById(id, lastName, firstName, age);
        }
    }
}
