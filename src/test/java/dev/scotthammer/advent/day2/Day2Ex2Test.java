package dev.scotthammer.advent.day2;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day2Ex2Test {

    @Test
    void zeroItemReportIsSafeWithDampener() {
        int[] report = {};
        assertTrue(Day2.isReportSafeWithDampener(report));

    }

    @Test
    void singleItemReportIsSafe() {
        int[] report = {15};
        assertTrue(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleOneIsSafe() {
        int[] report = {7, 6, 4, 2, 1};
        assertTrue(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleTwoIsNotSafe() {
        int[] report = {1, 2, 7, 8, 9};
        assertFalse(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleThreeIsNotSafe() {
        int[] report = {9, 7, 6, 2, 1};
        assertFalse(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleFourIsSafe() {
        int[] report = {1, 3, 2, 4, 5};
        assertTrue(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleFiveIsSafe() {
        int[] report = {8, 6, 4, 4, 1};
        assertTrue(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleSixIsSafe() {
        int[] report = {1, 3, 6, 7, 9};
        assertTrue(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleSevenIsNotSafe() {
        int[] report = {8, 6, 4, 4, 4, 1};
        assertFalse(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void exampleEightIsSafe() {
        int[] report = {8, 6, 4, 4, 3, 1};
        assertTrue(Day2.isReportSafeWithDampener(report));
    }

    @Test
    void puzzleEdgeCases() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day2-edgecases.txt")) {
            String[] reportInput = fileReader.lines().toArray(String[]::new);
            assertEquals(10, Day2.countSafeReports(reportInput, Day2::isReportSafeWithDampener));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void puzzleInputAnswer() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day2-input.txt")) {
            String[] reportInput = fileReader.lines().toArray(String[]::new);
            assertEquals(476, Day2.countSafeReports(reportInput, Day2::isReportSafeWithDampener));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
