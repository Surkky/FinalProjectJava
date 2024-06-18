package cardshop.finalprojectcardshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the shop which holds a list of cards and provides methods to load cards from a file.
 * @author Cruz Calderón Piñol
 * @version 1.0
 * @see HelloController
 * @see ListCards
 * @see SceneSwitch
 * @see Search
 * @see SearchCards
 * @see HelloApplication
 * @since 1.0
 */
public class Shop
{
    private List<SearchCards> cards;

    public Shop() {
        cards = new ArrayList<>();
    }
    /**
     * Gets the list of cards.
     * @return the list of cards.
     */
    public List<SearchCards> getCards() {
        return cards;
    }

    /**
     * Loads cards from a given file.
     * @param file the name of the file containing card details.
     * @throws IOException if an I/O error occurs.
     */
    public void loadCardsFromFile(String file) throws IOException {
        cards.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cardDetails = line.split(", ");
                if (cardDetails.length == 5) {
                    SearchCards card = new SearchCards();
                    card.setName(cardDetails[0]);
                    card.setCollection(cardDetails[1]);
                    card.setRarity(cardDetails[2]);
                    card.setDescription(cardDetails[3]);
                    card.setQuantity(Integer.parseInt(cardDetails[4]));
                    cards.add(card);
                }
            }
        }
    }
}
