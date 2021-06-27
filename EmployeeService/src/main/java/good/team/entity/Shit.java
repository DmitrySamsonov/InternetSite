package good.team.entity;

import good.team.service.EmployeeService;

public class Shit {

    public static void main(String[] args) {

        Employee employee = new Employee(4, "", "",111 );


        new EmployeeService().updatePersonById(employee);

    }
}
