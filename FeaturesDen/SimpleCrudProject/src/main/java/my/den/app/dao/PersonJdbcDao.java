package my.den.app.dao;

import my.den.app.entity.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonJdbcDao implements PersonDao {

    @Override
    public void createPerson(Person person) {
        try {
            Connection connection = new MySqlJdbcUtil().getConnection();
            Statement statement = connection.createStatement();
            {
                String name = person.getName();
                int age = person.getAge();
                String sql = "INSERT INTO `ppVLywhE9a`.`person` (`name`, `age`) VALUES ('" + name + "', '" + age + "');";
                statement.execute(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void deletePersonById(long id) {
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM `ppVLywhE9a`.`person` WHERE (`id` = '" + id + "');";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public Person readPersonById(long id) {
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM ppVLywhE9a.person where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String personName = resultSet.getString("name");
                int personAge = resultSet.getInt(3);
                Person person = new Person(id, personName, personAge);
                return person;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> readAllPersons() {
        ArrayList<Person> people = new ArrayList<>();
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM ppVLywhE9a.person";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int personId = resultSet.getInt(1);
                long id = resultSet.getInt(1);
                String personName = resultSet.getString("name");
                int personAge = resultSet.getInt(3);
                Person person = new Person(id, personName, personAge);
                people.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public void updatePersonById(long id, String name, int age) {
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE `ppVLywhE9a`.`person` SET `name` = '" + name + "', `age` = '" + age + "' WHERE (`id` = '" + id + "');";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePersonNameById(long id,String name){
        try (Connection connection = new MySqlJdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE `ppVLywhE9a`.`person` SET `name` = '" + name + "', `age` = NULL WHERE (`id` = '" + id + "');";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


