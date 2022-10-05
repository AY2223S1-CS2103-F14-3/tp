package seedu.address.model.application;

import seedu.address.commons.util.StringUtil;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that an {@code Application}'s {@code CompanyName} matches any of the keywords given.
 */
public class CompanyNameContainsKeywordsPredicate implements Predicate<Application> {
    private final List<String> keywords;

    public CompanyNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Application application) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(application.getCompanyName().companyName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CompanyNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((CompanyNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
