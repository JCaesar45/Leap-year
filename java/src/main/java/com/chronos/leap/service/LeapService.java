package com.chronos.leap.service;

import com.chronos.leap.model.LeapResult;

/**
 * Service layer implementing the Gregorian leap-year rule.
 *
 * <p>The rule is the standard Gregorian correction: a year is leap if it is
 * divisible by 4, unless divisible by 100, except when divisible by 400
 * (Meeus, 1991; ISO, 2019).</p>
 */
public final class LeapService {

    private LeapService() {
        // Utility / service class; no public instantiation.
    }

    /**
     * Determines whether the supplied year is a leap year.
     *
     * @param year a positive Gregorian year
     * @return a {@link LeapResult} containing the verdict
     * @throws IllegalArgumentException if year is not positive
     */
    public static LeapResult check(final int year) {
        if (year < 1) {
            throw new IllegalArgumentException("year must be a positive integer");
        }
        final boolean isLeap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        return new LeapResult(year, isLeap);
    }

    /**
     * Checks every year in an inclusive range.
     *
     * @param start the lower bound (inclusive)
     * @param end   the upper bound (inclusive)
     * @return an array of {@link LeapResult} ordered by year
     */
    public static LeapResult[] checkRange(final int start, final int end) {
        if (start > end) {
            return new LeapResult[0];
        }
        final LeapResult[] results = new LeapResult[end - start + 1];
        for (int i = 0; i < results.length; i++) {
            results[i] = check(start + i);
        }
        return results;
    }
}
