package my.app.service;

import my.app.dao.EmployeeDao;
import my.app.dao.EmployeeJdbcDao;
import my.app.entity.Employee;
import my.app.exception.EmployeeWebException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    EmployeeDao personDao;
    public static final String REG_EXP_LETTERS = "[A-Za-z]*";

    public EmployeeService() {
        personDao = new EmployeeJdbcDao();
        //personDao = new personJdbcDao();
    }

    public void createNewPerson(Employee person) {
        new EmployeeJdbcDao().createPerson(person);
    }


    public List<Employee> readAllPersons() {
        List<Employee> people = personDao.readAllPersons();
        return people;
    }


    public void updatePersonById(String personIdString, String personName, String personAgeString) throws EmployeeWebException {
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
                throw new EmployeeWebException(errorList);
            }

            Employee person = new Employee(personId, personName, personAge);
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
            throw new EmployeeWebException(errorList);
        }
        personDao.deletePersonById(id);

    }

    public void createPerson(String personName, String personAgeString) throws EmployeeWebException {
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
                throw new EmployeeWebException(errorList);
            }

            Employee person = new Employee(personName, personAge);
            createPerson(person);
        }
    }

    public void createPerson(Employee person) {
        personDao.createPerson(person);
    }

}
