package cardshop.finalprojectcardshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class for the Magic Card Shop.
 * This class extends {@link javafx.application.Application} and serves as the entry point for the JavaFX application.
 */
public class HelloApplication extends Application {
    /**
     * The main entry point for all JavaFX applications.
     * This method is called after the JavaFX runtime has been initialized.
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     * @throws IOException if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Magic Card Shop");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method is the entry point of the application.
     * This method launches the JavaFX application.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}