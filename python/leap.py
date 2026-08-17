"""Chronos Leap — Gregorian leap-year predicate.

The algorithm encodes the full Gregorian correction: a year is leap when it is
a multiple of 4, unless it is a centurial year, except when it is divisible by
400. This rule is specified in the papal bull Inter gravissimas (1582) and
standardised in ISO 8601 Annex B.3 (Meeus, 1991; ISO, 2019).
"""

from __future__ import annotations


def is_leap_year(year: int) -> bool:
    """Return True if *year* is a leap year in the Gregorian calendar.

    Args:
        year: A positive integer representing the Gregorian year.

    Returns:
        bool: Whether the year contains a 29 February.

    Raises:
        TypeError: If *year* is not an int.
        ValueError: If *year* is not a positive integer.

    Examples:
        >>> is_leap_year(2000)
        True
        >>> is_leap_year(1900)
        False
        >>> is_leap_year(2024)
        True
    """
    if not isinstance(year, int):
        raise TypeError("year must be an integer")
    if year < 1:
        raise ValueError("year must be a positive integer")
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)


def leap_years_between(start: int, end: int) -> list[int]:
    """Return all leap years in the inclusive range [start, end]."""
    if start > end:
        return []
    return [y for y in range(start, end + 1) if is_leap_year(y)]


if __name__ == "__main__":
    test_years = [2018, 2016, 2000, 1900, 1996, 1800, 1582, 2024]
    for y in test_years:
        print(f"{y}: {'leap' if is_leap_year(y) else 'common'} year")
