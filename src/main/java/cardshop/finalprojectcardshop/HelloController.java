package cardshop.finalprojectcardshop;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

/**
 * Controller class for handling the UI interactions in the Magic Card Shop application.
 * @author Cruz Calderón Piñol
 * @version 1.0
 * @see HelloApplication
 * @see ListCards
 * @see SceneSwitch
 * @see Search
 * @see SearchCards
 * @see Shop
 * @since 1.0
 */
public class HelloController {

    @FXML
    private Button abUsButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button listButton;

    @FXML
    private AnchorPane mainMenu;

    @FXML
    private Button searchButton;

    /**
     * Exits the application when the exit button is clicked.
     * @param event the action event triggered by clicking the exit button.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    void exitProgram(ActionEvent event) throws IOException {
        Platform.exit();
    }

    /**
     * Switches to the list cards scene when the list button is clicked.
     * @param event the action event triggered by clicking the list button.
     * @throws IOException if an I/O error occurs during scene switching.
     */
    @FXML
    void goList(ActionEvent event) throws IOException {
        new SceneSwitch(mainMenu, "listCards.fxml");
    }

    /**
     * Switches to the search scene when the search button is clicked.
     * @param event the action event triggered by clicking the search button.
     * @throws IOException if an I/O error occurs during scene switching.
     */
    @FXML
    void goSearch(ActionEvent event) throws IOException {
        new SceneSwitch(mainMenu, "search.fxml");
    }

    /**
     * Displays an information alert about the project when the about us button is clicked.
     * @param event the action event triggered by clicking the about us button.
     */
    @FXML
    void showInfo(ActionEvent event) {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("About us.");
        info.setContentText("Hello, this is my final project for Development Enviroments, I'm Cruz Calderón Piñol and I've developed this app.");
        Optional<ButtonType> result = info.showAndWait();
    }
}

