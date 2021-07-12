package good.team.dao;

import good.team.entity.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        employeeArrayList.add(new Employee(1,"aa", "bb" ,30));
        employeeArrayList.add(new Employee(2,"aa2", "bb2" ,30));
        employeeArrayList.add(new Employee(3,"aa3", "bb3" ,30));

        return employeeArrayList;
    }


    public Employee getEmployeeByIdJdbc(int id) {


        Employee employee = new Employee();
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `ppVLywhE9a`.`employee` SET ` where id=" + id;

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