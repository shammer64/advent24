package dev.scotthammer.advent.day4;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Ex1Test {

    private static final String[] EXAMPLE = {
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
    };

    @Test
    void gridTooSmallShouldReturnZero() {
        String[] input = {"XXX", "XXX", "XXX"};
        assertEquals(0, Day4.countXmas(input));
    }

    @Test
    void horizontalSingleRowForwardShouldBeFound() {
        String[] input = {"XXXMASXXX"};
        assertEquals(1, Day4.countXmas(input));
    }

    @Test
    void horizontalSingleRowBackwardShouldBeFound() {
        String[] input = {"XXXSAMXXX"};
        assertEquals(1, Day4.countXmas(input));
    }

    @Test
    void horizontalSingleRowForwardShouldFindMultiples() {
        String[] input = {"XMASXXMASXXMASX"};
        assertEquals(3, Day4.countXmas(input));
    }

    @Test
    void horizontalSingleRowBackwardShouldFindMultiples() {
        String[] input = {"XSAMXXSAMXXSAMX"};
        assertEquals(3, Day4.countXmas(input));
    }

    @Test
    void horizontalSingleRowMixedShouldFindMultiples() {
        String[] input = {"XSAMXXMASXXSAMX"};
        assertEquals(3, Day4.countXmas(input));
    }

    @Test
    void horizontalMultiRowMixedShouldFindMultiples() {
        String[] input = {"XSAMXXMASXXSAMX", "XSAMXXMASXXSAMX"};
        assertEquals(6, Day4.countXmas(input));
    }

    @Test
    void verticalSingleColumnForwardShouldBeFound() {
        String [] input = {"X", "X", "X", "M", "A", "S", "X", "X", "X"};
        assertEquals(1, Day4.countXmas(input));
    }

    @Test
    void verticalSingleColumnBackwardShouldBeFound() {
        String [] input = {"X", "X", "X", "S", "A", "M", "X", "X", "X"};
        assertEquals(1, Day4.countXmas(input));
    }

    @Test
    void verticalSingleColumnMixedShouldBeFound() {
        String [] input = {"X", "S", "A", "M", "X", "X", "S", "A", "M", "X", "X", "M", "A", "S", "X"};
        assertEquals(3, Day4.countXmas(input));
    }

    @Test
    void verticalMultiColumnMixedShouldBeFound() {
        String [] input = {"XX", "SM", "AA", "MS", "XX", "XX", "SM", "AA", "MS", "XX", "XX", "MS", "AA", "SM", "XX"};
        assertEquals(6, Day4.countXmas(input));
    }

    @Test
    void diagonalRightForwardShouldBeFound() {
        String[] input = {"XXXX", "XMXX", "XXAX", "XXXS"};
        assertEquals(1, Day4.countXmas(input));
    }

    @Test
    void diagonalRightBackwardShouldBeFound() {
        String[] input = {"SXXX", "XAXX", "XXMX", "XXXX"};
        assertEquals(1, Day4.countXmas(input));
    }

    @Test
    void diagonalLeftBackwardShouldBeFound() {
        String[] input = {"ABCX", "BCMA", "CAAB", "SABC"};
        assertEquals(1, Day4.countXmas(input));
    }

    @Test
    void exampleInstructionsCalculateCorrectly() {
        assertEquals(18, Day4.countXmas(EXAMPLE));
    }

    @Test
    void puzzleInputAnswer() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day4-input.txt")) {
            String[] input = fileReader.lines().toArray(String[]::new);
            assertEquals(2507, Day4.countXmas(input));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
