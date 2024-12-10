package dev.scotthammer.advent.day3;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Ex2Test {

    private static final String EXAMPLE = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

    @Test
    void exampleContainsTwoEnabledInstructions() {
        Instruction[] instructions = Day3.parseEnabledInstructions(EXAMPLE);

        assertEquals(2, instructions.length);
    }

    @Test
    void exampleInstructionsCalculateCorrectly() {
        Instruction[] instructions = Day3.parseEnabledInstructions(EXAMPLE);

        long sum = Arrays.stream(instructions)
                .mapToLong(Instruction::calculate)
                .sum();

        assertEquals(48, sum);
    }

    @Test
    void puzzleInputAnswer() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day3-input.txt")) {
            String[] memoryInput = fileReader.lines().toArray(String[]::new);
            String input = String.join("", memoryInput);
            long sumTotal = Arrays.stream(Day3.parseEnabledInstructions(input))
                    .mapToLong(Instruction::calculate)
                    .sum();
            assertEquals(100189366, sumTotal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
