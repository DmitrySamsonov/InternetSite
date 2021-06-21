package my.app.service;

import my.app.dao.PersonJDBCDao;
import my.app.entity.Person;

public class PersonService {
    public void createPerson(Person person){
        new PersonJDBCDao().createPerson(person);

    }
}
