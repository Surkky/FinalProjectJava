package cardshop.finalprojectcardshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
    private TableView<SearchCards> chartCards;

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

    private Shop shop;

    @FXML
    public void initialize() {
        shop = new Shop();
        try {
            shop.loadCardsFromFile("cards.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        cardName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cardCollection.setCellValueFactory(new PropertyValueFactory<>("collection"));
        cardDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        cardQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cardRarity.setCellValueFactory(new PropertyValueFactory<>("rarity"));
    }

    @FXML
    void searchByName(ActionEvent event) {
        String name = NameText.getText().trim().toLowerCase();
        List<SearchCards> filteredCards = shop.getCards().stream()
                .filter(card -> card.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
        updateTable(filteredCards);
    }

    /**
     * Searches for cards by collection and updates the table with the results.
     *
     * @param event the action event triggered by clicking the search by collection button.
     */
    @FXML
    void searchByCollection(ActionEvent event) {
        String collection = CollectionText.getText().trim().toLowerCase();
        List<SearchCards> filteredCards = shop.getCards().stream()
                .filter(card -> card.getCollection().toLowerCase().contains(collection))
                .collect(Collectors.toList());
        updateTable(filteredCards);
    }

    /**
     * Updates the table with a list of cards.
     *
     * @param cards the list of cards to display in the table.
     */
    private void updateTable(List<SearchCards> cards) {
        ObservableList<SearchCards> data = FXCollections.observableArrayList(cards);
        chartCards.setItems(data);
    }
}

