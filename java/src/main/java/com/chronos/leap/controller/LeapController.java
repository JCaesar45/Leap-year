package com.chronos.leap.controller;

import com.chronos.leap.model.LeapResult;
import com.chronos.leap.service.LeapService;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Minimal command-line controller for the leap-year service.
 *
 * <p>In a production Spring Boot or Quarkus deployment this class would be
 * mapped to HTTP endpoints; here it serves as a runnable CLI entry point.</p>
 */
public final class LeapController {

    private LeapController() {
        // Utility class.
    }

    public static void main(final String[] args) {
        if (args.length == 0) {
            final int[] samples = {2018, 2016, 2000, 1900, 1996, 1800, 2024};
            final String output = Arrays.stream(samples)
                    .mapToObj(LeapService::check)
                    .map(r -> r.year() + ": " + r.classification() + " year")
                    .collect(Collectors.joining("\n"));
            System.out.println(output);
            return;
        }

        try {
            final int year = Integer.parseInt(args[0]);
            final LeapResult result = LeapService.check(year);
            System.out.printf("%d is a %s year%n", result.year(), result.classification());
        } catch (NumberFormatException e) {
            System.err.println("Argument must be a valid integer year");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
