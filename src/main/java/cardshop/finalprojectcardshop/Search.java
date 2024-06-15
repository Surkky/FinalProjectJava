package cardshop.finalprojectcardshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for handling the search scene in the application.
 * @author Cruz Calderón Piñol
 * @version 1.0
 * @see HelloController
 * @see ListCards
 * @see SceneSwitch
 * @see HelloApplication
 * @see SearchCards
 * @see Shop
 * @since 1.0
 */
public class Search {
    @FXML
    private TextField CollectionText;

    @FXML
    private TableColumn<SearchCards, Integer> cardAdd;

    @FXML
    private TableColumn<SearchCards, String> cardCollection;

    @FXML
    private TableColumn<SearchCards, String> cardDescription;

    @FXML
    private TableColumn<SearchCards, String> cardName;

    @FXML
    private TableColumn<SearchCards, Integer> cardQty;

    @FXML
    private TableColumn<SearchCards, String> cardRarity;

    @FXML
    private TextField NameText;

    @FXML
    private TableView<SearchCards> chartCards;

    @FXML
    private Button exitButton;

    @FXML
    private Button searchCollection;
    @FXML
    public Button addButton;

    @FXML
    private AnchorPane searchFrame;

    @FXML
    private Button searchName;

    private Shop shop;
    private List<SearchCards> selectedCards = new ArrayList<>();

    /**
     * Switches to the main menu scene when the exit button is clicked.
     * @param event the action event triggered by clicking the exit button.
     * @throws IOException if an I/O error occurs during scene switching.
     */
    @FXML
    void goMainMenu(ActionEvent event) throws IOException {
        new SceneSwitch(searchFrame, "main.fxml");
    }

    /**
     * Initializes the shop, reads the file and locates the values into the table. Then it shows
     * the full list of cards and a way to select the quantity of cards you want to add to the list.
     */
    @FXML
    public void initialize() {
        shop = new Shop();
        try {
            shop.loadCardsFromFile("cards.txt");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        cardName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cardCollection.setCellValueFactory(new PropertyValueFactory<>("collection"));
        cardDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        cardQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cardRarity.setCellValueFactory(new PropertyValueFactory<>("rarity"));

        ObservableList<Integer> qtty = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5);
        cardAdd.setCellFactory(ComboBoxTableCell.forTableColumn(new IntegerStringConverter(), qtty));
        cardAdd.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        cardAdd.setOnEditCommit(event -> {
            SearchCards card = event.getRowValue();
            card.setQuantity(event.getNewValue());
            if (!selectedCards.contains(card)) {
                selectedCards.add(card);
            }
        });

        chartCards.setEditable(true);

        updateTable(shop.getCards());
    }

    /**
     * Searches for cards by name and updates the table with the results.
     * @param event the action event triggered by clicking the search by collection button.
     */
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
     * @param cards the list of cards to display in the table.
     */
    private void updateTable(List<SearchCards> cards) {
        ObservableList<SearchCards> data = FXCollections.observableArrayList(cards);
        chartCards.setItems(data);
    }

    /**
     * Saves the selected cards by the user into a file.
     */
    private void saveSelectedCardsToFile() throws IOException{
        String file = "listedCards.txt";
        try (BufferedWriter w = new BufferedWriter(new FileWriter(file))){
            for (SearchCards card : selectedCards){
                w.write(cardString(card));
                w.newLine();
            }
        }
        selectedCards.clear();
    }

    /**
     * Converts the cards into a unique String
     * @param card the list of cards the user selected.
     */
    private String cardString(SearchCards card){
        return card.getName() + ", " + card.getCollection() + ", " + card.getRarity() +
                ", " + card.getDescription() + ", " + card.getQuantity();
    }

    /**
     * Adds selected cards by user into a file.
     * @param actionEvent the action event triggered by clicking the add cards button.
     */
    public void addSelectedCards(ActionEvent actionEvent) {
        try{
            saveSelectedCardsToFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}