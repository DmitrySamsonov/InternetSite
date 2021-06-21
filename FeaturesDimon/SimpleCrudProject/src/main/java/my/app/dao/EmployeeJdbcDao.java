package my.app.dao;

import my.app.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJdbcDao implements EmployeeDao {

    @Override
    public void createEmployee(Employee employee) {
        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement();) {
            String name = employee.getName();
            int age = employee.getAge();
            String sql = "INSERT INTO `ppVLywhE9a`.`employee` (`name`, `age`) VALUES ('" + name + "', '" + age + "');";
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void deleteEmployeeById(int id) {
        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM `ppVLywhE9a`.`employee` WHERE (`id` = '" + id + "');";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateEmployee(Employee employee) {
            JdbcMysqlUtil jdbcMysqlUtil = new JdbcMysqlUtil();
            Connection connection = null;
            String newName = employee.getName();
            String newAge = Integer.toString(employee.getAge());
            String id = Integer.toString((int) employee.getId());

            try {
                connection = jdbcMysqlUtil.getConnection();
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();

                String sql =  "UPDATE `ppVLywhE9a`.`employee` SET `name` = '" + newName + "', `age` = '" + newAge + "' WHERE (`id` = '" + id + "');";
                statement.execute(sql);
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } finally {
                jdbcMysqlUtil.closeStatementAndConnection();
            }
        }

    @Override
    public Employee readEmployeeById(int id) {
        return null;
    }

    @Override
    public List<Employee> readAllEmployees() {
        ArrayList<Employee> people = new ArrayList<>();
        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM ppVLywhE9a.employee;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String employeeName = resultSet.getString("name");
                int employeeAge = resultSet.getInt(3);
                int employeeId = resultSet.getInt(1);

                Employee employee = new Employee(employeeId, employeeName, employeeAge);
                people.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }
}
