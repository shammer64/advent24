package dev.scotthammer.advent.day3;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Ex1Test {

    public static final String EXAMPLE = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

    @Test
    void exampleContainsFourInstructions() {
        Instruction[] instructions = Day3.parseInstructions(EXAMPLE);

        assertEquals(4, instructions.length);
    }
    
    @Test
    void exampleInstructionsCalculateCorrectly() {
        Instruction[] instructions = Day3.parseInstructions(EXAMPLE);

        long sum = Arrays.stream(instructions)
                .mapToLong(Instruction::calculate)
                .sum();

        assertEquals(161, sum);
    }

    @Test
    void puzzleInputAnswer() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day3-input.txt")) {
            String[] memoryInput = fileReader.lines().toArray(String[]::new);
            long sumTotal = Arrays.stream(memoryInput)
                    .map(Day3::parseInstructions)
                    .mapToLong(instructions -> Arrays.stream(instructions)
                            .mapToLong(Instruction::calculate)
                            .sum()
                    ).sum();
            assertEquals(155955228, sumTotal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
