package tree.family.graph;

import tree.family.controller.PersonController;
import tree.family.model.MainModel;

import java.util.List;

/**
 * Interface to generalize the graph
 */
public interface GraphInterface {
    /**
     * Method to get buttons of the graph.
     *
     * @param paneHeight: The height of the target pane.
     * @param model: Main model
     * @return the list of person buttons
     */
    List<PersonController> getPersonButtons(double paneHeight, MainModel model);
}
