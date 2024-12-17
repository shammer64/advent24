package dev.scotthammer.advent.day4;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static dev.scotthammer.advent.day4.Day4Ex1Test.EXAMPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Ex2Test {

    @Test
    void smallHorizontalInputShouldReturnZero() {
        String[] input = {"XX", "XX", "XX"};
        assertEquals(0, Day4.countCrossMas(input));
    }

    @Test
    void smallvERTICalInputShouldReturnZero() {
        String[] input = {"XXx", "XXx"};
        assertEquals(0, Day4.countCrossMas(input));
    }

    @Test
    void noMatchShouldReturnZero() {
        String[] input = {"XXX", "XXX", "XXX"};
        assertEquals(0, Day4.countCrossMas(input));
    }

    @Test
    void forwardForwardShouldBeFound() {
        String[] input = {"MXS", "XAX", "MXS"};
        assertEquals(1, Day4.countCrossMas(input));
    }

    @Test
    void forwardBackwardShouldBeFound() {
        String[] input = {"MXM", "XAX", "SXS"};
        assertEquals(1, Day4.countCrossMas(input));
    }

    @Test
    void backwardForwardShouldBeFound() {
        String[] input = {"SXS", "XAX", "MXM"};
        assertEquals(1, Day4.countCrossMas(input));
    }

    @Test
    void backwardBackwardShouldBeFound() {
        String[] input = {"SXM", "XAX", "SXM"};
        assertEquals(1, Day4.countCrossMas(input));
    }
    @Test
    void exampleInstructionsCalculateCorrectly() {
        assertEquals(9, Day4.countCrossMas(EXAMPLE));
    }

    @Test
    void puzzleInputAnswer() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day4-input.txt")) {
            String[] input = fileReader.lines().toArray(String[]::new);
            assertEquals(1969, Day4.countCrossMas(input));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
