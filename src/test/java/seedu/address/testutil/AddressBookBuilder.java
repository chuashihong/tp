package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.client.Client;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withclient("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code client} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withclient(Client client) {
        addressBook.addclient(client);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
