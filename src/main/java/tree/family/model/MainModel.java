package tree.family.model;

import tree.family.dao.MarriageDaoInterface;
import tree.family.dao.PersonDaoInterface;
import tree.family.data.Marriage;
import tree.family.data.Person;

import java.util.List;

/**
 * Model class of the model view control pattern
 */
public class MainModel {
    // Person data access object
    private final PersonDaoInterface personDao;
    // Marriage data access object
    private final MarriageDaoInterface marriageDao;

    /**
     * Constructor with necessary parameters
     *
     * @param personDao:   Person data access object
     * @param marriageDao: Marriage data access object
     */
    public MainModel(PersonDaoInterface personDao, MarriageDaoInterface marriageDao) {
        this.personDao = personDao;
        this.marriageDao = marriageDao;
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

    /**
     * Add a marriage to the data access object
     *
     * @param marriage: Instance of the marriage
     */
    public void addMarriage(Marriage marriage) {
        marriageDao.addMarriage(marriage);
    }

    /**
     * Remove a marriage from the data access object
     *
     * @param marriage: Instance of the marriage
     */
    public void removeMarriage(Marriage marriage) {
        marriageDao.removeMarriage(marriage);
    }

    /**
     * Update a marriage in the data access object
     *
     * @param marriage: Instance of the marriage
     */
    public void updateMarriage(Marriage marriage) {
        marriageDao.updateMarriage(marriage);
    }

    /**
     * Method to get all marriages from the data access object
     *
     * @return a list of all marriages
     */
    public List<Marriage> getAllMarriages() {
        return marriageDao.getAllMarriages();
    }
}
