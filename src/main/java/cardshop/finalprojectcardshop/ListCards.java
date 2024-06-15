package cardshop.finalprojectcardshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.List;

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
    public TableView<SearchCards> cardListByUser;
    @FXML
    private TableColumn<SearchCards, String> columnListCardName;

    @FXML
    private TableColumn<SearchCards, String> columnListCollection;

    @FXML
    private TableColumn<SearchCards, String> columnListDescription;

    @FXML
    private TableColumn<SearchCards, Integer> columnListQuantity;

    @FXML
    private TableColumn<SearchCards, String> columnListRarity;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane listCardsFrame;

    private Shop shop;

    /**
     * Switches to the main menu scene when the exit button is clicked.
     * @param event the action event triggered by clicking the exit button.
     * @throws IOException if an I/O error occurs during scene switching.
     */
    @FXML
    void goMainMenu(ActionEvent event) throws IOException {
        new SceneSwitch(listCardsFrame, "main.fxml");
    }
    //TO DO: change the way it shows the document selected, it shows the og file.
    /**
     * Initializes the shop, reads the file and locates the values into the table. Then it shows
     * the full list of cards and a way to select the quantity of cards you want to add to the list.
     */
    @FXML
    public void initialize() {
        shop = new Shop();
        try {
            shop.loadCardsFromFile("listedCards.txt");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        columnListCardName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnListCollection.setCellValueFactory(new PropertyValueFactory<>("collection"));
        columnListDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnListQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnListRarity.setCellValueFactory(new PropertyValueFactory<>("rarity"));

        updateTable(shop.getCards());
    }

    /**
     * Updates the table with a list of cards.
     * @param cards the list of cards to display in the table.
     */
    private void updateTable(List<SearchCards> cards) {
        ObservableList<SearchCards> data = FXCollections.observableArrayList(cards);
        cardListByUser.setItems(data);
    }
}

