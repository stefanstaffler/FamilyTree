package tree.family.util;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import tree.family.controller.PersonController;
import tree.family.data.Person;
import tree.family.view.PersonView;

/**
 * Graph util class
 * Every useful method which is needed more than once is defined in this class
 */
public class GraphUtil {
    /**
     * Create a pane of the current graph without the empty buttons
     *
     * @param targetPane: Pane of family tree
     * @return the result of the edited family tree
     */
    public static AnchorPane createPaneFromCurrentGraph(Pane targetPane) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(targetPane.getWidth(), targetPane.getHeight());

        for (Node node : targetPane.getChildren()) {
            if (node instanceof PersonController) {
                PersonController personController = (PersonController) node;
                Person person = personController.getPerson();
                String personName = person.getFirstName() + " " + person.getSurname();

                if (!personName.equals("New Person")) {
                    PersonView snapshotPersonView = new PersonView();
                    PersonController snapshotPersonController = new PersonController(snapshotPersonView, null);

                    PersonView personView = personController.getView();
                    snapshotPersonView.getRootPane().setLayoutX(personView.getRootPane().getLayoutX());
                    snapshotPersonView.getRootPane().setLayoutY(personView.getRootPane().getLayoutY());

                    snapshotPersonController.setData(person);
                    anchorPane.getChildren().add(snapshotPersonController);

                    Line line = getLineFromPane(targetPane, personView.getRootPane());
                    if (line != null) {
                        anchorPane.getChildren().add(line);
                    }
                }
            }
        }

        return anchorPane;
    }

    /**
     * Method to return the line before the button
     *
     * @param targetPane: Pane of family tree
     * @param pane: Root pane of the button
     * @return the line
     */
    private static Line getLineFromPane(Pane targetPane, Pane pane) {
        for (Node node : targetPane.getChildren()) {
            if (node instanceof Line) {
                Line line = (Line) node;

                if (line.getEndX() == pane.getLayoutX() && line.getEndY() == pane.getLayoutY() + pane.getPrefHeight() / 2) {
                    return new Line(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                }
            }
        }

        return null;
    }
}
