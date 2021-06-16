package my.app.dao;

import my.app.entity.Person;

import java.util.List;

public interface PersonDao {

    void createPerson(Person person);

    void deletePersonById(int id);

    void updatePerson(Person person);

    Person readPersonById(int id);

    List<Person> readAllPersons();


}
