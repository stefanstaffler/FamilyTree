package tree.family;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tree.family.controller.MainController;
import tree.family.dao.MarriageDaoInterface;
import tree.family.dao.MarriageDaoList;
import tree.family.dao.PersonDaoInterface;
import tree.family.dao.PersonDaoList;
import tree.family.graph.DrawGraph;
import tree.family.graph.GraphInterface;
import tree.family.model.MainModel;
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
     *
     * @param stage: This is the primary stage to set the main scene.
     */
    @Override
    public void start(Stage stage) {
        PersonDaoInterface personDao = new PersonDaoList();
        MarriageDaoInterface marriageDao = new MarriageDaoList();

        MainView mainView = new MainView();
        MainModel mainModel = new MainModel(personDao, marriageDao);
        MainController mainController = new MainController(mainView, mainModel);

        Pane rootPane = mainView.getRootPane();
        Scene scene = new Scene(rootPane, rootPane.getMinWidth(), rootPane.getMinHeight());

        stage.setScene(scene);

        GraphInterface graph = new DrawGraph();
        mainController.setGraph(graph);

        stage.show();
    }
}
