package seedu.address.model.application;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents an Application in the Application book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Application {

    // Identity fields
    private final Company company;
    private final Contact contact;
    private final Email email;
    private final Position position;

    /**
     * Every field must be present and not null.
     */
    public Application(Company company, Contact contact, Email email, Position position) {
        requireAllNonNull(company, contact, email, position);
        this.company = company;
        this.contact = contact;
        this.email = email;
        this.position = position;
    }

    public Company getCompany() {
        return company;
    }

    public Contact getContact() {
        return contact;
    }

    public Email getEmail() {
        return email;
    }

    public Position getPosition() {
        return position;
    }

    /**
     * Returns true if both applications have the same company and position.
     * This defines a weaker notion of equality between two applications.
     */
    public boolean isSameApplication(Application otherApplication) {
        if (otherApplication == this) {
            return true;
        }

        return otherApplication != null
                && otherApplication.getCompany().equals(getCompany())
                && otherApplication.getPosition().equals(getPosition());
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

        Application otherApplication = (Application) other;
        return otherApplication.getCompany().equals(getCompany())
                && otherApplication.getContact().equals(getContact())
                && otherApplication.getEmail().equals(getEmail())
                && otherApplication.getPosition().equals(getPosition());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(company, contact, email, position);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getCompany())
                .append("; Position applied: ")
                .append(getPosition())
                .append("; Contact number: ")
                .append(getContact())
                .append("; Email: ")
                .append(getEmail());

        return builder.toString();
    }

}
