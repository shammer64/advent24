package dev.scothammer.advent.day1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    @Test
    public void givenTwoEmptyLists_sumOfDiffsIsZero() {
        int[] list1 = {};
        int[] list2 = {};
        int sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(0, sum);
    }

    private static class Day1 {
        public static int sumOfDiffs(int[] list1, int[] list2) {
            return 0;
        }
    }
}
