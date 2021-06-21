package my.den.app.dao;

import my.den.app.entity.Person;

import java.util.List;

public interface PersonDao {

    void createPerson(Person person);

    void deletePersonById (long id);

    void updatePerson(Person person);

    Person readPersonById(long id);

    List<Person> readAllPersons();

    void updatePersonById(long id,String name, int age);

}
