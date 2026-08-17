"""Unit tests for the Chronos Leap Python implementation."""

import pytest

from leap import is_leap_year, leap_years_between


@pytest.mark.parametrize(
    "year,expected",
    [
        (2018, False),
        (2016, True),
        (2000, True),
        (1900, False),
        (1996, True),
        (1800, False),
        (1582, False),
        (2024, True),
        (1, False),
        (4, True),
        (100, False),
        (400, True),
        (3200, True),
        (3300, False),
    ],
)
def test_is_leap_year(year: int, expected: bool) -> None:
    assert is_leap_year(year) is expected


def test_invalid_types() -> None:
    with pytest.raises(TypeError):
        is_leap_year(2024.0)  # type: ignore[arg-type]
    with pytest.raises(TypeError):
        is_leap_year("2024")  # type: ignore[arg-type]


def test_invalid_values() -> None:
    with pytest.raises(ValueError):
        is_leap_year(0)
    with pytest.raises(ValueError):
        is_leap_year(-100)


def test_leap_years_between() -> None:
    assert leap_years_between(2000, 2004) == [2000, 2004]
    assert leap_years_between(2020, 2020) == [2020]
    assert leap_years_between(2021, 2023) == []
    assert leap_years_between(2024, 2020) == []
