package tree.family.graph;

import javafx.scene.shape.Line;
import tree.family.controller.MarriageController;
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
     * @param model:      Main model
     * @return the list of person buttons
     */
    List<PersonController> getPersonButtons(double paneHeight, MainModel model);

    /**
     * Method to get the lines between the buttons
     *
     * @param paneHeight: The height of the target pane.
     * @param model:      Main model
     * @return the list of lines
     */
    List<Line> getLines(double paneHeight, MainModel model);

    /**
     * Method to get the marriage buttons of the graph.
     *
     * @param paneHeight: The height of the target pane.
     * @param model:      Main model
     * @return the list of the marriage buttons
     */
    List<MarriageController> getMarriageButtons(double paneHeight, MainModel model);
}
