package tree.family.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tree.family.view.AddPersonView;

/**
 * Class for the add person controller
 */
public class AddPersonController extends BaseController {
    // Stage of the window
    private Stage stage;

    /**
     * Constructor with all necessary parameters
     *
     * @param view: Add person view
     */
    public AddPersonController(AddPersonView view) {
        super(view);

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
}
