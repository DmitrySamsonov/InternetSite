package good.team.dao;

import good.team.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class EmployeeJdbcDao {


    public Employee getEmployeeByIdJdbc(int id) {


        Employee employee = new Employee();
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `ppVLywhE9a`.`employee` where id=" + id;

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                int age = resultSet.getInt("age");
                employee.setAge(age);
                employee.setId(id);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);

            }
        } catch (SQLException throwables) {
            System.out.println("Something goes wrong");
            throwables.printStackTrace();
        }

        return employee;


    }
}