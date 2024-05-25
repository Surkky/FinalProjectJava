package cardshop.finalprojectcardshop;

/**
 * Represents a card in the Magic Card Shop application.
 * This class holds details about the card such as name, collection, rarity, description, and quantity.
 */
public class SearchCards
{
    private String name;
    private String collection;
    private String rarity;
    private String description;
    private int quantity;

    /**
     * Gets the name of the card.
     *
     * @return the name of the card.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the card.
     *
     * @param name the name of the card.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the collection to which the card belongs.
     *
     * @return the collection of the card.
     */
    public String getCollection() {
        return collection;
    }

    /**
     * Sets the collection to which the card belongs.
     *
     * @param collection the collection of the card.
     */
    public void setCollection(String collection) {
        this.collection = collection;
    }

    /**
     * Gets the rarity of the card.
     *
     * @return the rarity of the card.
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * Sets the rarity of the card.
     *
     * @param rarity the rarity of the card.
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * Gets the description of the card.
     *
     * @return the description of the card.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the card.
     *
     * @param description the description of the card.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the quantity of the card in stock.
     *
     * @return the quantity of the card.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the card in stock.
     *
     * @param quantity the quantity of the card.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
