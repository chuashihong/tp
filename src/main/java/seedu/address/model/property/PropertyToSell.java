package seedu.address.model.property;

/**
 * A demand indicating the property a seller wants to sell a house for, and the PriceRange it is willing to sell for.
 */
public class PropertyToSell {

    /**
     * The House a seller is selling.
     */
    private House house;

    /**
     * The PriceRange a buyer is willing to receive to sell the House.
     */
    private PriceRange priceRange;

    /**
     * The exact address of this house.
     */
    private Address address;

    /**
     * Constructs a PropertyToSell for the seller.
     * @param house the house that the seller is selling.
     * @param priceRange the PriceRange that a seller is willing to sell the property for.
     * @param address the exact address of the property the seller is selling.
     */
    public PropertyToSell(House house, PriceRange priceRange, Address address) {
        this.house = house;
        this.priceRange = priceRange;
        this.address = address;
    }

    public PropertyToSell updatePropertyToSell(HouseType houseType, Location location, PriceRange priceRange, Address address) {
        //Todo: need to implement updateHouseType for House class
        //this.house.updateHouseType(houseType);
        //this.house.updateLocation(location);
        this.house = new House(houseType, location.toString());
        this.priceRange = priceRange;
        this.address = address;
        return this;
    }

    public House getHouse() {
        return this.house;
    }

    public PriceRange getPriceRange() {
        return this.priceRange;
    }

    public Address getAddress() {
        return this.address;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof PropertyToSell // instanceof handles nulls
            && house.equals(((PropertyToSell) other).house)
            && priceRange.equals(((PropertyToSell) other).priceRange)
            && address.equals((((PropertyToSell) other).address))); // state check
    }
}
