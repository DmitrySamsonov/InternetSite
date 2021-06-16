package my.app.dao;

import my.app.entity.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonDaoJdbc implements PersonDao {

    @Override
    public void createPerson(Person person) {
        try (Connection connection = new MySqlJdbcUtil().getConnection();
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

    }


    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public Person readPersonById(int id) {
        return null;
    }

    @Override
    public List<Person> readAllPersons() {
        return null;
    }
}
