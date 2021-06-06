package tree.family.dao;

import tree.family.data.Marriage;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the marriage data access object with a list
 */
public class MarriageDaoList implements MarriageDaoInterface {
    // List which contains the marriages
    private final List<Marriage> marriageList;

    /**
     * Constructor
     */
    public MarriageDaoList() {
        marriageList = new LinkedList<>();
    }

    /**
     * Method to add a marriage to the list
     *
     * @param marriage: Instance of the marriage
     */
    @Override
    public void addMarriage(Marriage marriage) {
        marriageList.add(marriage);
    }

    /**
     * Method to remove a marriage from the list
     *
     * @param marriage: Instance of the marriage
     */
    @Override
    public void removeMarriage(Marriage marriage) {
        marriageList.remove(marriage);
    }

    /**
     * Method to update a marriage of the list
     *
     * @param marriage: Instance of the marriage
     */
    @Override
    public void updateMarriage(Marriage marriage) {
        if (marriageList.remove(marriage)) {
            marriageList.add(marriage);
        }
    }

    /**
     * Method to return the list of all marriages
     *
     * @return the list of all marriages
     */
    @Override
    public List<Marriage> getAllMarriages() {
        return marriageList;
    }
}
