package tree.family.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tree.family.view.AddPersonView;
import tree.family.view.MainView;

/**
 * Class for the main controller
 */
public class MainController extends BaseController {
    // Buttons from fxml file
    @FXML
    private Button addPersonButton;
    @FXML
    private Button exitButton;

    private final AddPersonController addPersonController;

    /**
     * Constructor with all necessary parameters.
     * @param view: Main view
     */
    public MainController(MainView view) {
        super(view);

        AddPersonView addPersonView = new AddPersonView();
        addPersonController = new AddPersonController(addPersonView);
    }

    /**
     * This method is called when a button from the left side menu is pressed
     * @param actionEvent: Action event
     */
    @FXML
    private void handleMenu(ActionEvent actionEvent) {
        Object sourceObject = actionEvent.getSource();

        if (sourceObject.equals(addPersonButton)) {
            showAddPersonWindow();
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
}
