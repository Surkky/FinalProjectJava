package cardshop.finalprojectcardshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Controller class for handling the search scene in the Magic Card Shop application.
 */
public class Search {

    @FXML
    private TextField CollectionText;

    @FXML
    private TableColumn<?, ?> cardAdd;

    @FXML
    private TableColumn<?, ?> cardCollection;

    @FXML
    private TableColumn<?, ?> cardDescription;

    @FXML
    private TableColumn<?, ?> cardName;

    @FXML
    private TableColumn<?, ?> cardQty;

    @FXML
    private TableColumn<?, ?> cardRarity;

    @FXML
    private TextField NameText;

    @FXML
    private TableView<?> chartCards;

    @FXML
    private Button exitButton;

    @FXML
    private Button searchCollection;

    @FXML
    private AnchorPane searchFrame;

    @FXML
    private Button searchName;

    /**
     * Switches to the main menu scene when the exit button is clicked.
     *
     * @param event the action event triggered by clicking the exit button.
     * @throws IOException if an I/O error occurs during scene switching.
     */
    @FXML
    void goMainMenu(ActionEvent event) throws IOException {
        new SceneSwitch(searchFrame, "main.fxml");
    }

}

