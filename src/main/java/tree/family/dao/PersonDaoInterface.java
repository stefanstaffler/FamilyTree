package tree.family.dao;

import tree.family.data.Person;

import java.util.List;

/**
 * Person data access object interface
 */
public interface PersonDaoInterface {
    /**
     * Add a person to the data access object
     *
     * @param person: Instance of the person
     */
    void addPerson(Person person);

    /**
     * Remove a person from the data access object
     *
     * @param person: Instance of the person
     */
    void removePerson(Person person);

    /**
     * Update a person in the data access object
     *
     * @param person: Instance of the person
     */
    void updatePerson(Person person);

    /**
     * Get all instances of the persons in the data access object
     *
     * @return all persons
     */
    List<Person> getAllPersons();
}
