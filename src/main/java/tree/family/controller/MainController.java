package tree.family.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    /**
     * Constructor with all necessary parameters.
     * @param view: Main view
     */
    public MainController(MainView view) {
        super(view);
    }

    /**
     * This method is called when a button from the left side menu is pressed
     * @param actionEvent: Action event
     */
    @FXML
    private void handleMenu(ActionEvent actionEvent) {
        Object sourceObject = actionEvent.getSource();

        if (sourceObject.equals(addPersonButton)) {

        } else if (sourceObject.equals(exitButton)) {
            Platform.exit();
        }
    }
}
