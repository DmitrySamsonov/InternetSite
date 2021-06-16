package my.app.service;

import my.app.dao.PersonDaoJdbc;
import my.app.entity.Person;

public class PersonService {

    public void createNewPerson(Person person) {
        new PersonDaoJdbc().createPerson(person);
    }

}
