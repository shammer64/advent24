package dev.scotthammer.advent.day1;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Day1Ex1Test {

    @Test
    void givenTwoEmptyLists_resultShouldBeZero() {
        long[] list1 = new long[0];
        long[] list2 = new long[0];
        assertEquals(0, Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenTwoSingleItemLists_resultShouldBeDiffOfTwoItems() {
        long[] list1 = {15};
        long[] list2 = {10};
        assertEquals(5, Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenTwoSingleItemListsReversed_resultShouldBeDiffOfTwoItems() {
        long[] list1 = {10};
        long[] list2 = {15};
        assertEquals(5, Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenOneNullList_shouldThrowException() {
        long[] list1 = {10};
        long[] list2 = null;
        assertThrows(IllegalArgumentException.class, () -> Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenAnotherNullList_shouldThrowException() {
        long[] list1 = null;
        long[] list2 = {10};
        assertThrows(IllegalArgumentException.class, () -> Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenTwoSortedTwoItemLists_resultShouldBeDiffOfItems() {
        long[] list1 = {15, 60};
        long[] list2 = {10, 25};
        assertEquals(40, Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenTwoUnsortedTwoItemLists_resultShouldBeDiffOfItems() {
        long[] list1 = {27, 19};
        long[] list2 = {10, 25};
        assertEquals(11, Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenSampleDataAsLists_resultShouldBeDiffOfItems() {
        long[] list1 = {3, 4, 2, 1, 3, 3};
        long[] list2 = {4, 3, 5, 3, 9, 3};
        assertEquals(11, Day1.computeDiffs(list1, list2));
    }

    @Test
    void givenDay1Input_computeResult() {
        try (BufferedReader fileReader = TestUtil.getBufferedReader("day1-input.txt")) {
            List<Long[]> values = fileReader.lines()
                    .map(line -> line.split("\\s+"))
                    .map(strings -> new Long[]{Long.valueOf(strings[0]), Long.valueOf(strings[strings.length - 1])})
                    .toList();
            long[] list1 = values.stream().map(array -> array[0]).mapToLong(Long::longValue).toArray();
            long[] list2 = values.stream().map(array -> array[1]).mapToLong(Long::longValue).toArray();
            assertEquals(1388114, Day1.computeDiffs(list1, list2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
