package tree.family.controller;

import javafx.fxml.FXMLLoader;
import tree.family.view.BaseView;

/**
 * Base class of all controllers
 */
public class BaseController {
    // Base view
    protected final BaseView view;

    /**
     * Constructor with all necessary base parameters.
     * @param baseView: Base view
     */
    public BaseController(BaseView baseView) {
        this.view = baseView;

        // Set the controller class in the fxml loader
        FXMLLoader fxmlLoader = view.getFxmlLoader();
        fxmlLoader.setController(this);

        // Load the view
        baseView.load();
    }
}
