package good.team;

import good.team.dao.EmployeeDao;
import good.team.dao.EmployeeJdbcDao;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeJdbcDao();
        employeeDao.deleteEmployeeById(1);
    }
}
