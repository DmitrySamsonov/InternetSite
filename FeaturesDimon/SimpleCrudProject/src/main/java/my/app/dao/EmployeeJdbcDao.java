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
    public void createPerson(Employee person) {
        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement();) {
            String name = person.getName();
            int age = person.getAge();
            String sql = "INSERT INTO `ppVLywhE9a`.`person` (`name`, `age`) VALUES ('" + name + "', '" + age + "');";
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void deletePersonById(int id) {
        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM `ppVLywhE9a`.`person` WHERE (`id` = '" + id + "');";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updatePerson(Employee person) {
            JdbcMysqlUtil jdbcMysqlUtil = new JdbcMysqlUtil();
            Connection connection = null;
            String newName = person.getName();
            String newAge = Integer.toString(person.getAge());
            String id = Integer.toString((int) person.getId());

            try {
                connection = jdbcMysqlUtil.getConnection();
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();

                String sql =  "UPDATE `ppVLywhE9a`.`person` SET `name` = '" + newName + "', `age` = '" + newAge + "' WHERE (`id` = '" + id + "');";
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
    public Employee readPersonById(int id) {
        return null;
    }

    @Override
    public List<Employee> readAllPersons() {
        ArrayList<Employee> people = new ArrayList<>();
        try (Connection connection = new JdbcMysqlUtil().getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM ppVLywhE9a.person;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String personName = resultSet.getString("name");
                int personAge = resultSet.getInt(3);
                int personId = resultSet.getInt(1);

                Employee person = new Employee(personId, personName, personAge);
                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }
}
