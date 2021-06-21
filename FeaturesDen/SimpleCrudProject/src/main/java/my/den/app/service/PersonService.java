package my.den.app.service;

import my.den.app.dao.PersonJdbcDao;
import my.den.app.entity.Person;

import java.util.List;

public class PersonService {

    public void createNewPerson(Person person) {
        new PersonJdbcDao().createPerson(person);

    }

    public Person readPersonById(long id) {
        return new PersonJdbcDao().readPersonById(id);

    }

    public List<Person> readAllPersons() {
        return new PersonJdbcDao().readAllPersons();
    }

    public void deletePersonById(long id) {
        new PersonJdbcDao().deletePersonById(id);
    }

    public void updatePersonById(long id, String name, String ageString) {

        if (ageString == null) {
            new PersonJdbcDao().updatePersonNameById(id, name);
        } else {
            int age = Integer.parseInt(ageString);
            new PersonJdbcDao().updatePersonById(id, name, age);
        }
    }
}
