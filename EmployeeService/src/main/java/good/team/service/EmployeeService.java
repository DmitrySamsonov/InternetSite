package good.team.service;


import good.team.dao.EmployeeJdbcDao;
import good.team.entity.Employee;

public class EmployeeService {
    EmployeeJdbcDao employeeJdbcDao = new EmployeeJdbcDao();

   public Employee getEmployeeById(String id){


       try {
           int id1 = Integer.parseInt(id);
           employeeJdbcDao.getEmployeeByIdJdbc(id1);
       }
       catch (Exception e) {
           System.out.println("You enter wrong data");
           e.printStackTrace();
       }


       return null;
   }

}
