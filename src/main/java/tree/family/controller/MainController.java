package tree.family.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import tree.family.data.Person;
import tree.family.model.MainModel;
import tree.family.view.AddPersonView;
import tree.family.view.MainView;
import tree.family.view.PersonView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for the main controller
 */
public class MainController extends BaseController {
    // Buttons from fxml file
    @FXML
    private Button addPersonButton;
    @FXML
    private Button exitButton;

    // Controller of the add person window
    private final AddPersonController addPersonController;

    // Family tree anchor pane
    @FXML
    private AnchorPane familyTreeAnchorPane;

    // MainModel
    private final MainModel model;

    /**
     * Constructor with all necessary parameters.
     *
     * @param view: Main view
     */
    public MainController(MainView view, MainModel model) {
        super(view);

        this.model = model;

        AddPersonView addPersonView = new AddPersonView();
        addPersonController = new AddPersonController(addPersonView, model);
    }

    /**
     * This method is called when a button from the left side menu is pressed
     *
     * @param actionEvent: Action event
     */
    @FXML
    private void handleMenu(ActionEvent actionEvent) {
        Object sourceObject = actionEvent.getSource();

        if (sourceObject.equals(addPersonButton)) {
            showAddPersonWindow();
            updateFamilyTree();
        } else if (sourceObject.equals(exitButton)) {
            Platform.exit();
        }
    }

    /**
     * Shows the window to add a person
     */
    private void showAddPersonWindow() {
        addPersonController.show();
    }

    /**
     * Load every person from the model and create a family tree
     */
    private void updateFamilyTree() {
        List<Person> personList = model.getAllPersons();

        ObservableList<Node> familyTreeNodeList = familyTreeAnchorPane.getChildren();

        Person rootPerson = personList.stream().filter(person -> person.getChildren() == null || person.getChildren().isEmpty()).collect(Collectors.toList()).get(0);

        PersonView personView = new PersonView();
        PersonController personController = new PersonController(personView);

        personView.getRootPane().setLayoutX(0);
        double totalHeight = familyTreeAnchorPane.getHeight();
        double objectHeight = personView.getRootPane().getPrefHeight();
        personView.getRootPane().setLayoutY(totalHeight / 2 - objectHeight / 2);

        personController.setData(rootPerson);
        familyTreeNodeList.add(personController);
    }
}
