package tree.family.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import tree.family.data.Person;
import tree.family.view.PersonView;

public class PersonController extends BorderPane {
    // Person labels
    @FXML
    private Label nameLabel;

    /**
     * Constructor with all necessary base parameters.
     *
     * @param view: Person view
     */
    public PersonController(PersonView view) {
        view.getFxmlLoader().setController(this);
        view.getFxmlLoader().setRoot(this);
        view.load();
    }

    /**
     * Method to set the data
     */
    public void setData(Person person) {
        nameLabel.setText(person.getFirstName() + " " + person.getSurname());
    }
}
