package my.app.dao;

import my.app.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void createPerson(Employee person);

    void deletePersonById(int id);

    void updatePerson(Employee person);

    Employee readPersonById(int id);

    List<Employee> readAllPersons();


}
