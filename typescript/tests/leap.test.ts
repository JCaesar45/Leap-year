import { describe, expect, it } from "vitest";
import { isLeapYear, leapYearsBetween } from "../src/leap";

describe("isLeapYear", () => {
  it.each([
    [2018, false],
    [2016, true],
    [2000, true],
    [1900, false],
    [1996, true],
    [1800, false],
    [1582, false],
    [2024, true],
    [1, false],
    [4, true],
    [100, false],
    [400, true],
    [3200, true],
    [3300, false],
  ])("isLeapYear(%d) === %s", (year, expected) => {
    expect(isLeapYear(year)).toBe(expected);
  });

  it("rejects non-integers", () => {
    expect(() => isLeapYear(2024.5)).toThrow(TypeError);
    expect(() => isLeapYear(Number.NaN)).toThrow(TypeError);
  });

  it("rejects non-positive years", () => {
    expect(() => isLeapYear(0)).toThrow(RangeError);
    expect(() => isLeapYear(-100)).toThrow(RangeError);
  });
});

describe("leapYearsBetween", () => {
  it("finds leap years in a range", () => {
    expect(leapYearsBetween(2000, 2004)).toEqual([2000, 2004]);
    expect(leapYearsBetween(2020, 2020)).toEqual([2020]);
    expect(leapYearsBetween(2021, 2023)).toEqual([]);
  });
});
