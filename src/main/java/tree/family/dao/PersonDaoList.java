package tree.family.dao;

import tree.family.data.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the person data access object with a list
 */
public class PersonDaoList implements PersonDaoInterface {
    // List which contains the persons
    private final List<Person> personList;

    /**
     * Constructor
     */
    public PersonDaoList() {
        personList = new LinkedList<>();
    }

    /**
     * Method to add a person to the list
     *
     * @param person: Instance of the person
     */
    @Override
    public void addPerson(Person person) {
        personList.add(person);
    }

    /**
     * Method to remove a person from the list
     *
     * @param person: Instance of the person
     */
    @Override
    public void removePerson(Person person) {
        personList.remove(person);
    }

    /**
     * Method to update a person of the list
     *
     * @param person: Instance of the person
     */
    @Override
    public void updatePerson(Person person) {
        if (personList.remove(person)) {
            personList.add(person);
        }
    }

    /**
     * Method to return the list of all persons
     *
     * @return the list of all persons
     */
    @Override
    public List<Person> getAllPersons() {
        return personList;
    }
}
