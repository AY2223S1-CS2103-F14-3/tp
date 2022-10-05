package seedu.address.model.application;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.tag.Tag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents an Application in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Application {

    // Identity fields
    private final CompanyName companyName;
    private final ContactNumber contactNumber;
    private final Email email;
    private final PositionApplied positionApplied;

    // Data fields
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Application(CompanyName companyName, ContactNumber contactNumber, Email email, PositionApplied positionApplied, Set<Tag> tags) {
        requireAllNonNull(companyName, contactNumber, email, positionApplied, tags);
        this.companyName = companyName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.positionApplied = positionApplied;
        this.tags.addAll(tags);
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }

    public Email getEmail() {
        return email;
    }

    public PositionApplied getPositionApplied() {
        return positionApplied;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both applications have the same companyName and positionApplied.
     * This defines a weaker notion of equality between two applications.
     */
    public boolean isSameApplication(Application otherApplication) {
        if (otherApplication == this) {
            return true;
        }

        return otherApplication != null
                && otherApplication.getCompanyName().equals(getCompanyName())
                && otherApplication.getPositionApplied().equals(getPositionApplied());
    }

    /**
     * Returns true if both applications have the same identity and data fields.
     * This defines a stronger notion of equality between two applications.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Application)) {
            return false;
        }

        Application otherPerson = (Application) other;
        return otherPerson.getCompanyName().equals(getCompanyName())
                && otherPerson.getContactNumber().equals(getContactNumber())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getPositionApplied().equals(getPositionApplied())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(companyName, contactNumber, email, positionApplied, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getCompanyName())
                .append("; Position: ")
                .append(getPositionApplied())
                .append("; Contact number: ")
                .append(getContactNumber())
                .append("; Email: ")
                .append(getEmail());


        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

}
