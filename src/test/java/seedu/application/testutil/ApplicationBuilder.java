package seedu.application.testutil;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.application.model.application.Application;
import seedu.application.model.application.Company;
import seedu.application.model.application.Contact;
import seedu.application.model.application.Date;
import seedu.application.model.application.Email;
import seedu.application.model.application.Position;
import seedu.application.model.application.interview.Interview;
import seedu.application.model.tag.Tag;
import seedu.application.model.util.SampleDataUtil;

/**
 * A utility class to help with building Application objects.
 */
public class ApplicationBuilder {

    public static final String DEFAULT_COMPANY = "Google";
    public static final String DEFAULT_CONTACT = "85355255";
    public static final String DEFAULT_DATE = "2022-01-01";
    public static final String DEFAULT_EMAIL = "google@gmail.com";
    public static final String DEFAULT_POSITION = "Software Engineer";

    private Company company;
    private Contact contact;
    private Date date;
    private Email email;
    private Position position;
    private Set<Tag> tags;
    private Optional<Interview> interview;

    /**
     * Creates an {@code ApplicationBuilder} with the default details.
     */
    public ApplicationBuilder() {
        company = new Company(DEFAULT_COMPANY);
        contact = new Contact(DEFAULT_CONTACT);
        date = new Date(DEFAULT_DATE);
        email = new Email(DEFAULT_EMAIL);
        position = new Position(DEFAULT_POSITION);
        tags = new HashSet<>();
        interview = Optional.empty();
    }

    /**
     * Initializes the ApplicationBuilder with the data of {@code applicationToCopy}.
     */
    public ApplicationBuilder(Application applicationToCopy) {
        company = applicationToCopy.getCompany();
        contact = applicationToCopy.getContact();
        date = applicationToCopy.getDate();
        email = applicationToCopy.getEmail();
        position = applicationToCopy.getPosition();
        tags = new HashSet<>(applicationToCopy.getTags());
        if (applicationToCopy.getInterview().isPresent()) {
            interview = applicationToCopy.getInterview();
        } else {
            interview = Optional.empty();
        }
    }

    /**
     * Sets the {@code Company} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withCompany(String company) {
        this.company = new Company(company);
        return this;
    }

    /**
     * Sets the {@code Contact} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withContact(String contact) {
        this.contact = new Contact(contact);
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Position} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withPosition(String position) {
        this.position = new Position(position);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Application} that we are building.
     */
    public ApplicationBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Interview} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withInterview(Interview interview) {
        this.interview = Optional.of(interview);
        return this;
    }

    /**
     * Create Application with its fields.
     * @return created Application.
     */
    public Application build() {
        if (this.interview.isPresent()) {
            return new Application(new Application(company, contact, email, position, date, tags), interview.get());
        } else {
            return new Application(company, contact, email, position, date, tags);
        }
    }

}
