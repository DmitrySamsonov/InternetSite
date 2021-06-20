package my.app.service;

import my.app.dao.PersonDao;
import my.app.dao.PersonJdbcDao;
import my.app.entity.Person;
import my.app.exception.PersonWebException;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonDao personDao;
    public static final String REG_EXP_LETTERS = "[A-Za-z]*";

    public PersonService() {
        personDao = new PersonJdbcDao();
        //personDao = new personJdbcDao();
    }

    public void createNewPerson(Person person) {
        new PersonJdbcDao().createPerson(person);
    }


    public List<Person> readAllPersons() {
        List<Person> people = personDao.readAllPersons();
        return people;
    }


    public void updatePersonById(String personIdString, String personName, String personAgeString) throws PersonWebException {
        ArrayList<String> errorList = new ArrayList<>();

        if (personName != null && personAgeString != null) {
            if (personName.length() < 3 || personName.length() > 15) {
                String message = "personName not in range in 2-15";
                errorList.add(message);
            }
            if (!personName.matches(REG_EXP_LETTERS)) {
                String message = "personName has no correct symbols";
                errorList.add(message);
            }

            int personAge = 0;
            try {
                personAge = Integer.parseInt(personAgeString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (personAge < 0) {
                String message = "age cannot be negative";
                errorList.add(message);
            }

            int personId = 0;
            try {
                personId = Integer.parseInt(personIdString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (personId < 0) {
                String message = "id cannot be negative";
                errorList.add(message);
            }


            if (errorList.size() > 0) {
                throw new PersonWebException(errorList);
            }

            Person person = new Person(personId, personName, personAge);
            personDao.updatePerson(person);

        }
    }

    public void deletePersonById(int id) {
        ArrayList<String> errorList = new ArrayList<>();

        if (id < 0) {
            String message = "id deleted person cannot be negative";
            errorList.add(message);
        }

        if (errorList.size() > 0) {
            throw new PersonWebException(errorList);
        }
        personDao.deletePersonById(id);

    }

    public void createPerson(String personName, String personAgeString) throws PersonWebException {
        ArrayList<String> errorList = new ArrayList<>();

        if (personName != null && personAgeString != null) {
            if (personName.length() < 3 || personName.length() > 15) {
                String message = "personName not in range in 2-15";
                errorList.add(message);
            }
            if (!personName.matches(REG_EXP_LETTERS)) {
                String message = "personName has no correct symbols";
                errorList.add(message);
            }

            int personAge = 0;
            try {
                personAge = Integer.parseInt(personAgeString);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                String message = "My error!!!!";
                errorList.add(message);
            }

            if (personAge < 0) {
                String message = "age cannot be negative";
                errorList.add(message);
            }

            if (errorList.size() > 0) {
                throw new PersonWebException(errorList);
            }

            Person person = new Person(personName, personAge);
            createPerson(person);
        }
    }

    public void createPerson(Person person) {
        personDao.createPerson(person);
    }

}
