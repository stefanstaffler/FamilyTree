package tree.family.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Base view of all views
 */
public class BaseView {
    // Root pane of the view
    private Pane rootPane;
    // Fxml loader with the matching fxml file
    private final FXMLLoader fxmlLoader;

    /**
     * Creating the base view and instantiate the fxml loader
     */
    public BaseView() {
        Class<? extends BaseView> classObject = getClass();
        String className = classObject.getSimpleName();
        // Instantiate a fxml loader with the class name and the file extension ".fxml"
        fxmlLoader = new FXMLLoader(classObject.getResource(className + ".fxml"));
    }

    /**
     * Loading the fxml file and assign the root pane
     */
    public void load() {
        try {
            rootPane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the root pane of the view.
     * @return root pane
     */
    public Pane getRootPane() {
        return rootPane;
    }

    /**
     * Returns the fxml loader of the view.
     * @return fxml loader
     */
    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }
}
