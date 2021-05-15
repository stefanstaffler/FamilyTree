package tree.family.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import tree.family.data.Person;
import tree.family.model.MainModel;
import tree.family.view.AddPersonView;

/**
 * Class for the add person controller
 */
public class AddPersonController extends BaseController {
    // Stage of the window
    private Stage stage;

    // MainModel
    private MainModel model;

    // Buttons from the button bar from fxml file
    @FXML
    private Button cancelButton;
    @FXML
    private Button addButton;

    // Other fields from the fxml file
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
    // Relatives fields
    @FXML
    private ComboBox<Person> fatherComboBox;
    @FXML
    private ComboBox<Person> motherComboBox;
    @FXML
    private CheckComboBox<Person> childrenCheckComboBox;

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
            stage.close();
        } else if (sourceObject.equals(addButton)) {
            addPerson();
        }
    }

    /**
     * Method to add a person to the main model
     */
    private void addPerson() {
        // TODO Add this person using the model
        String firstName = firstNameTextField.getText();
        String middleName = middleNameTextField.getText();
        String surname = surnameTextField.getText();

        String birthday = birthdayTextField.getText();
        String birthplace = birthplaceTextField.getText();

        String dyingDay = dyingDayTextField.getText();
        String placeOfDeath = placeOfDeathTextField.getText();

        Person father = fatherComboBox.getValue();
        Person mother = motherComboBox.getValue();
        ObservableList<Person> children = childrenCheckComboBox.getCheckModel().getCheckedItems();

        stage.close();
    }
}
