package good.team.dao;

import good.team.entity.Employee;

public interface EmployeeDao {
    void updateEmployeeById(int id, String lastName, String firstName, int age);


}
