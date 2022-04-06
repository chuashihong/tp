package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.buyer.Buyer;
import seedu.address.model.property.NullPropertyToBuy;
import seedu.address.model.seller.AllFieldsMatchBuyerPredicate;


/**
 * Matches and finds all sellers in UniqueSellerList whose PropertyToSell matches with the Buyer's PropertyToBuy.
 */
public class MatchCommand extends Command {

    public static final String COMMAND_WORD = "match";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all sellers whose specified fields matches "
        + "the given buyer index and displays them as a list with index numbers.\n"
        + "Parameters: BUYER_INDEX...\n"
        + "Example: " + COMMAND_WORD + " 2";

    private final Index index;

    public MatchCommand(Index index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ObservableList<Buyer> buyerList = model.getFilteredBuyerList();

        if (index.getZeroBased() >= buyerList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX);
        }

        Buyer buyer = buyerList.get(index.getZeroBased());

        if (buyer.getPropertyToBuy() instanceof NullPropertyToBuy) {
            throw new CommandException(Messages.MESSAGE_NO_PROPERTY_ADDED);
        }

        model.updateFilteredSellerList(new AllFieldsMatchBuyerPredicate(buyer));

        return new CommandResult(
            String.format(Messages.MESSAGE_SELLERS_LISTED_OVERVIEW, model.getFilteredSellerList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof MatchCommand // instanceof handles nulls
            && index.equals(((MatchCommand) other).index)); // state check
    }
}
