package dev.scothammer.advent.day1;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

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

    @Test
    public void givenOneNullList_throwAssertionError() {
        long[] list1 = null;
        long[] list2 = {15L};
        assertThrows(AssertionError.class,
                () -> Day1.sumOfDiffs(list1, list2));
    }

    @Test
    public void givenTwoSortedTwoItemLists_sumOfDiffsIsDiffOfItems() {
        long[] list1 = {15L, 21L};
        long[] list2 = {8L, 17L};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(15, sum);
    }

    @Test
    public void givenTwoUnsortedTwoItemLists_sumOfDiffsIsDiffOfItems() {
        long[] list1 = {21L, 15L};
        long[] list2 = {8L, 17L};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(15, sum);
    }

//     Sample Input
//        3   4
//        4   3
//        2   5
//        1   3
//        3   9
//        3   3

    private static class Day1 {
        public static long sumOfDiffs(long[] list1, long[] list2) {
            assert(list1 != null && list2 != null);
            if (list1.length != list2.length) {
                throw new IllegalArgumentException("Lists must be of equal length");
            }
            long sum = 0;
            Arrays.sort(list1);
            Arrays.sort(list2);
            for (int i = 0; i < list1.length; i++) {
                sum += Math.abs(list1[i] - list2[list2.length - 1 - i]);
            }
            return sum;
        }
    }
}
