package tree.family.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import tree.family.data.Marriage;
import tree.family.model.MainModel;
import tree.family.view.AddMarriageView;

import java.text.DateFormat;
import java.text.ParseException;

/**
 * Class for the add marriage controller
 */
public class AddMarriageController extends BaseController {
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
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField placeTextField;

    // Marriage
    @Getter
    private Marriage marriage;

    /**
     * Constructor with all necessary parameters
     *
     * @param view:  Add marriage view
     * @param model: Main model
     */
    public AddMarriageController(AddMarriageView view, MainModel model) {
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
        stage.setTitle("Add marriage");
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    /**
     * Shows the window
     */
    public void show() {
        dateTextField.clear();
        placeTextField.clear();

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
            addMarriage();
        }
    }

    /**
     * Method to add a marriage to the main model
     */
    private void addMarriage() {
        String date = dateTextField.getText();
        String place = placeTextField.getText();

        marriage = new Marriage();

        try {
            if (date != null && !date.isEmpty())
                marriage.setDate(DateFormat.getDateInstance().parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        marriage.setPlace(place);

        model.addMarriage(marriage);

        stage.close();
    }
}
