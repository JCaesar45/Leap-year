package com.chronos.leap.model;

/**
 * Immutable value object representing the outcome of a leap-year check.
 *
 * @param year   the Gregorian year queried
 * @param isLeap whether the year is a leap year
 */
public record LeapResult(int year, boolean isLeap) {

    /**
     * Returns a human-readable classification string.
     */
    public String classification() {
        return isLeap ? "leap" : "common";
    }
}
