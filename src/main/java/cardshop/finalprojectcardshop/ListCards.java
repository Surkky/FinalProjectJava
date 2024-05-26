package cardshop.finalprojectcardshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Controller class for handling the list cards scene in the application.
 * @author Cruz Calderón Piñol
 * @version 1.0
 * @see HelloController
 * @see HelloApplication
 * @see SceneSwitch
 * @see Search
 * @see SearchCards
 * @see Shop
 * @since 1.0
 */
public class ListCards {

    @FXML
    private TableColumn<?, ?> columnListCardName;

    @FXML
    private TableColumn<?, ?> columnListCollection;

    @FXML
    private TableColumn<?, ?> columnListDescription;

    @FXML
    private TableColumn<?, ?> columnListQuantity;

    @FXML
    private TableColumn<?, ?> columnListRarity;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane listCardsFrame;

    /**
     * Switches to the main menu scene when the exit button is clicked.
     * @param event the action event triggered by clicking the exit button.
     * @throws IOException if an I/O error occurs during scene switching.
     */
    @FXML
    void goMainMenu(ActionEvent event) throws IOException {
        new SceneSwitch(listCardsFrame, "main.fxml");
    }
}

