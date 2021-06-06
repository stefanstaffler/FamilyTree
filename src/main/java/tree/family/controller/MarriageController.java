package tree.family.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import lombok.Getter;
import tree.family.data.Marriage;
import tree.family.model.MainModel;
import tree.family.view.AddMarriageView;
import tree.family.view.MarriageView;

/**
 * Controller class of the marriage which is visible on the pane
 */
public class MarriageController extends BorderPane {
    // Button
    @FXML
    private Button marriageButton;

    // Label
    @FXML
    private Label marriageLabel;

    // MarriageView
    @Getter
    private final MarriageView view;

    // Main model
    private final MainModel model;

    // Marriage object
    @Getter
    private Marriage marriage;

    /**
     * Constructor with all necessary base parameters.
     *
     * @param view:  Marriage view
     * @param model: Main model
     */
    public MarriageController(MarriageView view, MainModel model) {
        view.getFxmlLoader().setController(this);
        view.getFxmlLoader().setRoot(this);
        view.load();

        this.view = view;
        this.model = model;
    }

    /**
     * Method to set the data
     *
     * @param marriage: Instance of the marriage
     */
    public void setData(Marriage marriage) {
        this.marriage = marriage;
        marriageLabel.setText(marriage.toString());
    }

    /**
     * Handles action of button
     *
     * @param actionEvent: Instance of the action event
     */
    @FXML
    private void onMarriageButton(ActionEvent actionEvent) {
        AddMarriageView addMarriageView = new AddMarriageView();
        AddMarriageController addMarriageController = new AddMarriageController(addMarriageView, model);
        addMarriageController.show();

        Marriage marriage = addMarriageController.getMarriage();
        if (marriage != null) {
            setData(marriage);
        }
    }
}
