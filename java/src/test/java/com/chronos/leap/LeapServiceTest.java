package com.chronos.leap;

import com.chronos.leap.model.LeapResult;
import com.chronos.leap.service.LeapService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LeapServiceTest {

    @ParameterizedTest(name = "year {0} should be leap = {1}")
    @CsvSource({
        "2018, false",
        "2016, true",
        "2000, true",
        "1900, false",
        "1996, true",
        "1800, false",
        "1582, false",
        "2024, true",
        "1, false",
        "4, true",
        "100, false",
        "400, true",
        "3200, true",
        "3300, false"
    })
    @DisplayName("matches the Gregorian rule")
    void testLeapYearRule(int year, boolean expected) {
        assertEquals(expected, LeapService.check(year).isLeap());
    }

    @Test
    @DisplayName("rejects non-positive years")
    void testInvalidYear() {
        assertThrows(IllegalArgumentException.class, () -> LeapService.check(0));
        assertThrows(IllegalArgumentException.class, () -> LeapService.check(-100));
    }

    @Test
    @DisplayName("returns a readable classification")
    void testClassification() {
        assertEquals("leap", LeapService.check(2024).classification());
        assertEquals("common", LeapService.check(2023).classification());
    }

    @Test
    @DisplayName("checkRange returns ordered results")
    void testCheckRange() {
        final LeapResult[] results = LeapService.checkRange(2000, 2004);
        assertEquals(5, results.length);
        assertTrue(results[0].isLeap()); // 2000
        assertFalse(results[1].isLeap()); // 2001
        assertFalse(results[2].isLeap()); // 2002
        assertFalse(results[3].isLeap()); // 2003
        assertTrue(results[4].isLeap()); // 2004
    }
}
