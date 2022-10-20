package seedu.application.testutil;

import seedu.application.model.application.Date;
import seedu.application.model.application.interview.Interview;
import seedu.application.model.application.interview.InterviewDate;
import seedu.application.model.application.interview.InterviewTime;
import seedu.application.model.application.interview.Location;
import seedu.application.model.application.interview.Round;

/**
 * A utility class to help with building Interview objects.
 */
public class InterviewBuilder {

    public static final String DEFAULT_ROUND = "Google";
    public static final String DEFAULT_INTERVIEW_DATE = "85355255";
    public static final String DEFAULT_INTERVIEW_TIME = "google@gmail.com";
    public static final String DEFAULT_LOCATION = "Software Engineer";

    private Round round;
    private InterviewDate interviewDate;
    private Date date;
    private InterviewTime interviewTime;
    private Location location;

    /**
     * Creates an {@code InterviewBuilder} with the default details.
     */
    public InterviewBuilder() {
        round = new Round(DEFAULT_ROUND);
        interviewDate = new InterviewDate(DEFAULT_INTERVIEW_DATE);
        interviewTime = new InterviewTime(DEFAULT_INTERVIEW_TIME);
        location = new Location(DEFAULT_LOCATION);
    }

    /**
     * Initializes the InterviewBuilder with the data of {@code interviewToCopy}.
     */
    public InterviewBuilder(Interview interviewToCopy) {
        round = interviewToCopy.getRound();
        interviewDate = interviewToCopy.getInterviewDate();
        interviewTime = interviewToCopy.getInterviewTime();
        location = interviewToCopy.getLocation();
    }

    /**
     * Sets the {@code Round} of the {@code Interview} that we are building.
     */
    public InterviewBuilder withRound(String round) {
        this.round = new Round(round);
        return this;
    }

    /**
     * Sets the {@code InterviewDate} of the {@code Interview} that we are building.
     */
    public InterviewBuilder withInterviewDate(String interviewDate) {
        this.interviewDate = new InterviewDate(interviewDate);
        return this;
    }

    /**
     * Sets the {@code InterviewTime} of the {@code Interview} that we are building.
     */
    public InterviewBuilder withInterviewTime(String interviewTime) {
        this.interviewTime = new InterviewTime(interviewTime);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Interview} that we are building.
     */
    public InterviewBuilder withLocation(String location) {
        this.location = new Location(location);
        return this;
    }

    public Interview build() {
        return new Interview(round, interviewDate, interviewTime, location);
    }

}