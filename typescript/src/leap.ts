/**
 * Chronos Leap — Gregorian leap-year predicate.
 *
 * Implements the standard Gregorian correction: leap when divisible by 4,
 * except centurial years, unless divisible by 400 (Meeus, 1991; ISO, 2019).
 */

export type Year = number;

/**
 * Determines whether a year is a leap year in the Gregorian calendar.
 *
 * @param year - A positive integer Gregorian year.
 * @returns `true` if the year is a leap year.
 * @throws If `year` is not a safe positive integer.
 */
export function isLeapYear(year: Year): boolean {
  if (!Number.isInteger(year)) {
    throw new TypeError("year must be an integer");
  }
  if (year < 1 || year > Number.MAX_SAFE_INTEGER) {
    throw new RangeError("year must be a positive safe integer");
  }
  return year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0);
}

/**
 * Returns every leap year within an inclusive range.
 */
export function leapYearsBetween(start: Year, end: Year): Year[] {
  const result: Year[] = [];
  for (let y = start; y <= end; y += 1) {
    if (isLeapYear(y)) result.push(y);
  }
  return result;
}

// Minimal sanity check when executed directly with ts-node / tsx.
if (import.meta.url === `file://${process.argv[1]}`) {
  const samples = [2018, 2016, 2000, 1900, 1996, 1800, 2024];
  for (const year of samples) {
    console.log(`${year}: ${isLeapYear(year) ? "leap" : "common"} year`);
  }
}
