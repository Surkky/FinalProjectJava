package cardshop.finalprojectcardshop;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

/**
 * Utility class for switching scenes within an AnchorPane in the application.
 * @author Cruz Calderón Piñol
 * @version 1.0
 * @see HelloController
 * @see ListCards
 * @see HelloApplication
 * @see Search
 * @see SearchCards
 * @see Shop
 * @since 1.0
 */
public class SceneSwitch {

    /**
     * Constructs a SceneSwitch object and loads a new FXML scene into the provided AnchorPane.
     * @param current the current AnchorPane where the new scene will be loaded.
     * @param fxml    the FXML file to load the new scene from.
     * @throws IOException if the FXML file cannot be loaded.
     */
    public SceneSwitch(AnchorPane current, String fxml) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        current.getChildren().removeAll();
        current.getChildren().setAll(nextAnchorPane);
    }
}
