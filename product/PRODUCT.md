# Chronos Leap — Product Structure

## Vision
Chronos Leap transforms a single, well-known algorithm into a portfolio-grade demonstration of cross-stack engineering. It is a luxury landing page backed by identical leap-year predicates in Python, TypeScript, and Java.

## Target Audiences
- **Companies & clients**: see production-quality design and multi-runtime reliability.
- **Hackers**: inspect boundary handling, validation, and test coverage.
- **Developers**: compare idiomatic implementations across languages.

## Features
- Immersive HTML/CSS/JS landing page with animated starfield and glassmorphism.
- Client-side leap-year check with history chips.
- Server-grade Python, TypeScript, and Java implementations.
- Comprehensive unit tests in each language.

## File Layout
```
chronos-leap/
├── index.html                          # Single-file luxury frontend
├── README.md                           # Project narrative
├── product/PRODUCT.md                  # This document
├── backend/
│   ├── python/
│   │   ├── leap.py                     # Predicate + range helper
│   │   └── test_leap.py                # pytest suite
│   ├── typescript/
│   │   ├── src/leap.ts                 # Typed predicate
│   │   ├── tests/leap.test.ts          # Vitest suite
│   │   ├── package.json                # Dependencies
│   │   └── tsconfig.json               # TypeScript config
│   └── java/
│       ├── pom.xml                     # Maven config
│       └── src/
│           ├── main/java/com/chronos/leap/
│           │   ├── controller/LeapController.java
│           │   ├── service/LeapService.java
│           │   └── model/LeapResult.java
│           └── test/java/com/chronos/leap/LeapServiceTest.java
```

## Verification
- Python: `pytest backend/python/test_leap.py`
- TypeScript: `cd backend/typescript && npm test`
- Java: `cd backend/java && mvn test`
- Frontend: open `index.html` in any modern browser.

## References
- International Organization for Standardization. (2019). *ISO 8601-1:2019 Annex B.3*. Geneva: ISO.
- Meeus, J. (1991). *Astronomical algorithms*. Richmond, VA: Willmann-Bell.
