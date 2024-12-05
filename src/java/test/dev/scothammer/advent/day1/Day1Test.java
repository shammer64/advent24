package dev.scothammer.advent.day1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    @Test
    public void givenTwoEmptyLists_sumOfDiffsIsZero() {
        long[] list1 = {};
        long[] list2 = {};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(0, sum);
    }

    private static class Day1 {
        public static int sumOfDiffs(long[] list1, long[] list2) {
            return 0;
        }
    }
}
