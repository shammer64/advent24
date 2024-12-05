package dev.scothammer.advent.day1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Day1Test {

    @Test
    public void givenTwoEmptyLists_sumOfDiffsIsZero() {
        long[] list1 = {};
        long[] list2 = {};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(0, sum);
    }

    @Test
    public void givenTwoSingleItemLists_sumOfDiffsIsDiffOfItems() {
        long[] list1 = {15L};
        long[] list2 = {8L};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(7, sum);
    }

    @Test
    public void givenTwoSingleItemLists_sumOfDiffsIsPositiveDiffOfItems() {
        long[] list1 = {8L};
        long[] list2 = {15L};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(7, sum);
    }

    @Test
    public void givenTwoListsOfDiffLength_throwException() {
        long[] list1 = {8L, 19L};
        long[] list2 = {15L};
        assertThrows(IllegalArgumentException.class,
                () -> Day1.sumOfDiffs(list1, list2));
    }

    private static class Day1 {
        public static long sumOfDiffs(long[] list1, long[] list2) {
            if (list1.length != list2.length) {
                throw new IllegalArgumentException("Lists must be of equal length");
            }
            if (list1.length > 0) {
                return Math.abs(list1[0] - list2[0]);
            }
            return 0;
        }
    }
}
