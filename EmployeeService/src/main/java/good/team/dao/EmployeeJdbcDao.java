package good.team.dao;

import good.team.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeeJdbcDao implements EmployeeDao {

    @Override
    public void updateEmployeeById(int id, String lastName, String firstName, int age) {

        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE `ppVLywhE9a`.`employee` SET `" +
                    "lastName` = '" + lastName + "', " +
                    "`firstName` = '" + firstName + "', " +
                    "`age` = '" + age + "' WHERE (`id` = '" + id + "');";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateEmployeeSQLById(int id, String lastNameSQL, String firstNameSQL, String AgeSQL) {
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "UPDATE `ppVLywhE9a`.`employee` SET " + lastNameSQL + firstNameSQL +
                    AgeSQL + " WHERE (`id` = '" + id + "');";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }
}




