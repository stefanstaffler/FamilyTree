package tree.family.controller;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import tree.family.data.Person;
import tree.family.graph.GraphInterface;
import tree.family.model.MainModel;
import tree.family.view.MainView;
import tree.family.view.PersonView;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Class for the main controller
 */
public class MainController extends BaseController {
    // Buttons from fxml file
    @FXML
    private Button exitButton;
    @FXML
    private Button saveButton;

    // Family tree anchor pane
    @FXML
    private AnchorPane familyTreeAnchorPane;

    // MainModel
    private final MainModel model;

    // Graph instance
    private GraphInterface graph;

    /**
     * Constructor with all necessary parameters.
     *
     * @param view: Main view
     */
    public MainController(MainView view, MainModel model) {
        super(view);

        this.model = model;
    }

    /**
     * This method is called when a button from the left side menu is pressed
     *
     * @param actionEvent: Action event
     */
    @FXML
    private void handleMenu(ActionEvent actionEvent) {
        Object sourceObject = actionEvent.getSource();

        if (sourceObject.equals(saveButton)) {
            AnchorPane anchorPane = createPaneFromCurrentGraph();

            Scene scene = new Scene(anchorPane);

            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
            File file = fileChooser.showSaveDialog(saveButton.getScene().getWindow());

            WritableImage writableImage = new WritableImage((int) anchorPane.getPrefWidth(), (int) anchorPane.getPrefHeight());
            anchorPane.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);

            if (file != null) {
                try {
                    ImageIO.write(renderedImage, "png", file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (sourceObject.equals(exitButton)) {
            Platform.exit();
        }
    }

    /**
     * Create a pane of the current graph without the empty buttons
     *
     * @return the result of the edited family tree
     */
    private AnchorPane createPaneFromCurrentGraph() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(familyTreeAnchorPane.getPrefWidth(), familyTreeAnchorPane.getPrefHeight());

        for (Node node : familyTreeAnchorPane.getChildren()) {
            if (node instanceof PersonController) {
                PersonController personController = (PersonController) node;
                Person person = personController.getPerson();
                String personName = person.getFirstName() + " " + person.getSurname();

                if (!personName.equals("New Person")) {
                    PersonView snapshotPersonView = new PersonView();
                    PersonController snapshotPersonController = new PersonController(snapshotPersonView, model);

                    PersonView personView = personController.getView();
                    snapshotPersonView.getRootPane().setLayoutX(personView.getRootPane().getLayoutX());
                    snapshotPersonView.getRootPane().setLayoutY(personView.getRootPane().getLayoutY());

                    snapshotPersonController.setData(person);
                    anchorPane.getChildren().add(snapshotPersonController);
                }
            }
        }

        return anchorPane;
    }

    /**
     * Sets the target graph in the view
     *
     * @param graph: Instance of the target graph
     */
    public void setGraph(GraphInterface graph) {
        if (this.graph == null) {
            this.graph = graph;
        }

        familyTreeAnchorPane.getChildren().clear();

        List<PersonController> personControllerList = graph.getPersonButtons(familyTreeAnchorPane.getPrefHeight(), model);
        List<Line> lineList = graph.getLines(familyTreeAnchorPane.getPrefHeight(), model);

        familyTreeAnchorPane.getChildren().addAll(personControllerList);
        familyTreeAnchorPane.getChildren().addAll(lineList);
    }
}
