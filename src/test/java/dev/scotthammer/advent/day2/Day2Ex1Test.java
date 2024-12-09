package dev.scotthammer.advent.day2;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day2Ex1Test {

    @Test
    void zeroItemReportIsSafe() {
        int[] report = {};
        assertTrue(Day2.isReportSafe(report));
    }

    @Test
    void singleItemReportIsSafe() {
        int[] report = {15};
        assertTrue(Day2.isReportSafe(report));
    }

    @Test
    void twoItemReportWithAscendingGapOfFourIsNotSafe() {
        int[] report = {15, 19};
        assertFalse(Day2.isReportSafe(report));
    }

    @Test
    void twoItemReportWithNoChangeIsNotSafe() {
        int[] report = {15, 15};
        assertFalse(Day2.isReportSafe(report));
    }

    @Test
    void twoItemReportWithAscendingGapOfThreeIsSafe() {
        int[] report = {15, 18};
        assertTrue(Day2.isReportSafe(report));
    }

    @Test
    void twoItemReportWithDescendingGapOfFourIsNotSafe() {
        int[] report = {19, 15};
        assertFalse(Day2.isReportSafe(report));
    }

    @Test
    void twoItemReportWithDescendingGapOfThreeIsSafe() {
        int[] report = {18, 15};
        assertTrue(Day2.isReportSafe(report));
    }

    @Test
    void exampleOneIsSafe() {
        int[] report = {7, 6, 4, 2, 1};
        assertTrue(Day2.isReportSafe(report));
    }

    @Test
    void exampleTwoIsNotSafe() {
        int[] report = {1, 2, 7, 8, 9};
        assertFalse(Day2.isReportSafe(report));
    }

    @Test
    void exampleThreeIsNotSafe() {
        int[] report = {9, 7, 6, 2, 1};
        assertFalse(Day2.isReportSafe(report));
    }

    @Test
    void exampleFourIsNotSafe() {
        int[] report = {1, 3, 2, 4, 5};
        assertFalse(Day2.isReportSafe(report));
    }

    @Test
    void exampleFiveIsNotSafe() {
        int[] report = {8, 6, 4, 4, 1};
        assertFalse(Day2.isReportSafe(report));
    }

    @Test
    void exampleSixIsSafe() {
        int[] report = {1, 3, 6, 7, 9};
        assertTrue(Day2.isReportSafe(report));
    }

    @Test
    void exampleInputContainsTwoSafeReports() {
        String[] reportInput = {
                "7 6 4 2 1", "1 2 7 8 9",
                "9 7 6 2 1", "1 3 2 4 5",
                "8 6 4 4 1", "1 3 6 7 9"
        };
        assertEquals(2, Day2.countSafeReports(reportInput));
    }

    @Test
    void puzzleInputAnswer() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day2-input.txt")) {
            String[] reportInput = fileReader.lines().toArray(String[]::new);
            assertEquals(421, Day2.countSafeReports(reportInput, Day2::isReportSafe));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
