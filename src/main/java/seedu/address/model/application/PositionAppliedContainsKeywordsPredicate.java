package seedu.address.model.application;

import seedu.address.commons.util.StringUtil;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that an {@code Application}'s {@code PositionApplied} matches any of the keywords given.
 */
public class PositionAppliedContainsKeywordsPredicate implements Predicate<Application> {
    private final List<String> keywords;

    public PositionAppliedContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Application application) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(application.getPositionApplied().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PositionAppliedContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((PositionAppliedContainsKeywordsPredicate) other).keywords)); // state check
    }

}
