package tree.family.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import lombok.Getter;
import tree.family.data.Person;
import tree.family.model.MainModel;
import tree.family.view.AddPersonView;
import tree.family.view.PersonView;

/**
 * Controller class of the person who is visible on the pane
 */
public class PersonController extends BorderPane {
    // Button
    @FXML
    private Button personButton;

    // PersonView
    @Getter
    private PersonView view;

    // Main model
    private MainModel model;

    // Person object
    @Getter
    private Person person;

    /**
     * Constructor with all necessary base parameters.
     *
     * @param view:  Person view
     * @param model: Main model
     */
    public PersonController(PersonView view, MainModel model) {
        view.getFxmlLoader().setController(this);
        view.getFxmlLoader().setRoot(this);
        view.load();

        this.view = view;
        this.model = model;
    }

    /**
     * Method to set the data
     *
     * @param person: Instance of the person
     */
    public void setData(Person person) {
        this.person = person;
        personButton.setText(person.getFirstName() + " " + person.getSurname());
    }

    /**
     * Handles action of button
     *
     * @param actionEvent: Instance of the action event
     */
    @FXML
    private void handlePersonButton(ActionEvent actionEvent) {
        AddPersonView addPersonView = new AddPersonView();
        AddPersonController addPersonController = new AddPersonController(addPersonView, model, person);
        addPersonController.show();

        person = addPersonController.getPerson();
        if (person != null) {
            setData(person);
        }
    }
}
