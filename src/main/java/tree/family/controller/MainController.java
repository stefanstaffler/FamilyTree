package tree.family.controller;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import tree.family.graph.GraphInterface;
import tree.family.model.MainModel;
import tree.family.util.FileUtil;
import tree.family.util.GraphUtil;
import tree.family.util.ImageUtil;
import tree.family.view.MainView;

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
            AnchorPane anchorPane = GraphUtil.createPaneFromCurrentGraph(familyTreeAnchorPane);
            File file = FileUtil.getTargetImageFile(saveButton.getScene().getWindow());
            ImageUtil.savePaneToImage(anchorPane, file);
        } else if (sourceObject.equals(exitButton)) {
            Platform.exit();
        }
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
