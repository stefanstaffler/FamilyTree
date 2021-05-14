package tree.family;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tree.family.controller.MainController;
import tree.family.view.MainView;

/**
 * Main class of this application
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method of this application. Shows the main window.
     * @param stage: This is the primary stage to set the main scene.
     */
    @Override
    public void start(Stage stage) {
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);

        Pane rootPane = mainView.getRootPane();
        Scene scene = new Scene(rootPane, rootPane.getMinWidth(), rootPane.getMinHeight());

        stage.setScene(scene);
        stage.show();
    }
}
