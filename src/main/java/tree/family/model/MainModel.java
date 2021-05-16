package tree.family.model;

import tree.family.dao.PersonDaoInterface;
import tree.family.data.Person;

import java.util.List;

/**
 * Model class of the model view control pattern
 */
public class MainModel {
    // Person data access object
    private final PersonDaoInterface personDao;

    /**
     * Constructor with necessary parameters
     *
     * @param personDao: Person data access object
     */
    public MainModel(PersonDaoInterface personDao) {
        this.personDao = personDao;
    }

    /**
     * Add a person to the data access object
     *
     * @param person: Instance of the person
     */
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    /**
     * Remove a person from the data access object
     *
     * @param person: Instance of the person
     */
    public void removePerson(Person person) {
        personDao.removePerson(person);
    }

    /**
     * Update a person in the data access object
     *
     * @param person: Instance of the person
     */
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    /**
     * Method to get all persons from the data access object
     *
     * @return a list of all persons
     */
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }
}
