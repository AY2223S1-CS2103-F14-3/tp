package seedu.application.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.application.commons.core.Messages;
import seedu.application.commons.core.index.Index;
import seedu.application.logic.commands.exceptions.CommandException;
import seedu.application.model.Model;
import seedu.application.model.application.Application;

public class RetrieveCommand extends Command {
    public static final String COMMAND_WORD = "retrieve";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Retrieve the application identified by the index number used in the displayed archive list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_APPLICATION_IS_NOT_ARCHIVE = "The application by the index is not archived.\n"
            + "Please switch to archive list using <list-archive> command before using <retrieve> command.\n"
            + "Example: 1) " + ListArchiveCommand.COMMAND_WORD + "\n"
            + "              2) " + COMMAND_WORD + " 1";

    public static final String MESSAGE_ARCHIVE_APPLICATION_SUCCESS = "Retrieved Application: %1$s";

    private final Index targetIndex;

    public RetrieveCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Application> lastShownList = model.getFilteredApplicationList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ARCHIVE_APPLICATION_DISPLAYED_INDEX);
        }

        Application applicationToRetrieve = lastShownList.get(targetIndex.getZeroBased());

        if (!applicationToRetrieve.isArchived()) {
            throw new CommandException(MESSAGE_APPLICATION_IS_NOT_ARCHIVE);
        }
        model.retrieveApplication(applicationToRetrieve);
        return new CommandResult(String.format(MESSAGE_ARCHIVE_APPLICATION_SUCCESS, applicationToRetrieve));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RetrieveCommand // instanceof handles nulls
                && targetIndex.equals(((RetrieveCommand) other).targetIndex)); // state check
    }
}
