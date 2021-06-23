package good.team.dao;

import good.team.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeJdbcDao {

    public static Employee getEmployeeByIdJdbc(int id) {


        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM new_ferma.employee where id=" + id;

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                int age = resultSet.getInt(4);
                Employee employee = new Employee(id, lastName, firstName, age);
                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }
}