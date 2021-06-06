package tree.family.dao;

import tree.family.data.Marriage;

import java.util.List;

/**
 * Marriage data access object interface
 */
public interface MarriageDaoInterface {
    /**
     * Add a marriage to the data access object
     *
     * @param marriage: Instance of the marriage
     */
    void addMarriage(Marriage marriage);

    /**
     * Remove a marriage from the data access object
     *
     * @param marriage: Instance of the marriage
     */
    void removeMarriage(Marriage marriage);

    /**
     * Update a marriage in the data access object
     *
     * @param marriage: Instance of the marriage
     */
    void updateMarriage(Marriage marriage);

    /**
     * Get all instances of the marriages in the data access object
     *
     * @return all marriages
     */
    List<Marriage> getAllMarriages();
}
