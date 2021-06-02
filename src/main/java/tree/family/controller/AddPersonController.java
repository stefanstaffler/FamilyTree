package tree.family.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import tree.family.data.Person;
import tree.family.model.MainModel;
import tree.family.view.AddPersonView;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;

/**
 * Class for the add person controller
 */
public class AddPersonController extends BaseController {
    // Stage of the window
    private Stage stage;

    // MainModel
    private final MainModel model;

    // Buttons from the button bar from fxml file
    @FXML
    private Button cancelButton;
    @FXML
    private Button addButton;

    // Other fields from the fxml file
    // Gender field
    @FXML
    private ChoiceBox<Person.Gender> genderChoiceBox;
    // Name fields
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField middleNameTextField;
    @FXML
    private TextField surnameTextField;
    // Birth fields
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextField birthplaceTextField;
    // Death fields
    @FXML
    private TextField dyingDayTextField;
    @FXML
    private TextField placeOfDeathTextField;

    // Person
    @Getter
    private Person person;

    /**
     * Constructor with all necessary parameters
     *
     * @param view: Add person view
     */
    public AddPersonController(AddPersonView view, MainModel model) {
        super(view);

        this.model = model;

        initWindow();
    }

    /**
     * Initialize the window stage
     */
    private void initWindow() {
        Pane rootPane = view.getRootPane();
        Scene scene = new Scene(rootPane, rootPane.getMinWidth(), rootPane.getMinHeight());

        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add person");
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    /**
     * Shows the window
     */
    public void show() {
        genderChoiceBox.setItems(FXCollections.observableList(Arrays.asList(Person.Gender.values())));
        genderChoiceBox.setValue(Person.Gender.NONE);

        firstNameTextField.clear();
        middleNameTextField.clear();
        surnameTextField.clear();

        birthdayTextField.clear();
        birthplaceTextField.clear();

        dyingDayTextField.clear();
        placeOfDeathTextField.clear();

        stage.showAndWait();
    }

    /**
     * Method to handle events of the button bar
     *
     * @param actionEvent: ActionEvent
     */
    @FXML
    private void handleButtonBar(ActionEvent actionEvent) {
        Object sourceObject = actionEvent.getSource();

        if (sourceObject.equals(cancelButton)) {
            person = null;
            stage.close();
        } else if (sourceObject.equals(addButton)) {
            addPerson();
        }
    }

    /**
     * Method to add a person to the main model
     */
    private void addPerson() {
        Person.Gender gender = genderChoiceBox.getValue();

        String firstName = firstNameTextField.getText();
        String middleName = middleNameTextField.getText();
        String surname = surnameTextField.getText();

        String birthday = birthdayTextField.getText();
        String birthplace = birthplaceTextField.getText();

        String dyingDay = dyingDayTextField.getText();
        String placeOfDeath = placeOfDeathTextField.getText();

        person = new Person();

        person.setGender(gender);

        person.setFirstName(firstName);
        person.setMiddleName(middleName);
        person.setSurname(surname);

        try {
            if (birthday != null && !birthday.isEmpty())
                person.setBirthday(DateFormat.getDateInstance().parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        person.setBirthplace(birthplace);

        try {
            if (dyingDay != null && !dyingDay.isEmpty())
                person.setDyingDay(DateFormat.getDateInstance().parse(dyingDay));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        person.setPlaceOfDeath(placeOfDeath);

        model.addPerson(person);

        stage.close();
    }
}
