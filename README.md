# Chronos Leap

> A luxury, algorithmic shrine to the Gregorian leap year.

Chronos Leap is not a toy. It is a cross-stack engineering artifact built around one of the most elegant calendar-correction rules in history: a year is leap if divisible by 4, unless divisible by 100, except when divisible by 400.

The project ships a cinematic single-page website, plus identical, production-hardened implementations in **Python**, **TypeScript**, and **Java** — each with full unit-test coverage.

---

## Why This Exists

The leap-year rule is simple, yet it exposes the difference between "works on my machine" and "works everywhere". I built Chronos Leap as a reference architecture for:

- Beautiful, performant front-end experiences without frameworks.
- Type-safe, validated backend predicates.
- Cross-language consistency enforced by shared test matrices.
- Clean separation between model, service, and controller layers.

---

## Quick Start

### Frontend
Open `index.html` in any modern browser. No build step. No dependencies.

### Python
```bash
cd backend/python
pytest test_leap.py
```

### TypeScript
```bash
cd backend/typescript
npm install
npm test
```

### Java
```bash
cd backend/java
mvn test
```

---

## The Algorithm

```
year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
```

This encodes the Gregorian reform of 1582. Without the 100/400 exceptions, the calendar would drift by roughly one day every 128 years (Meeus, 1991).

---

## References

- International Organization for Standardization. (2019). *ISO 8601-1:2019 Annex B.3*. Geneva: ISO.
- Meeus, J. (1991). *Astronomical algorithms*. Richmond, VA: Willmann-Bell.
