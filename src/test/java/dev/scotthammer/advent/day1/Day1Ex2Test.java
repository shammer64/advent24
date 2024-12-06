package dev.scotthammer.advent.day1;

import dev.scotthammer.advent.TestUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Ex2Test {

    @Test
    void givenTwoEmptyLists_resultShouldBeZero() {
        long[] list1 = new long[0];
        long[] list2 = new long[0];
        assertEquals(0, Day1.computeSimilarity(list1, list2));
    }

    @Test
    void givenTwoIdenticalSingleItemLists_resultShouldBeValueOfFirstItem() {
        long[] list1 = {8};
        long[] list2 = {8};
        assertEquals(8, Day1.computeSimilarity(list1, list2));
    }

    @Test
    void givenTwoDifferentSingleItemLists_resultShouldBeValueOfFirstItem() {
        long[] list1 = {8};
        long[] list2 = {9};
        assertEquals(0, Day1.computeSimilarity(list1, list2));
    }

    @Test
    void givenItemWithTwoOccurencesInList2_resultShouldBeDoubleValueOfFirstItem() {
        long[] list1 = {8};
        long[] list2 = {8, 8};
        assertEquals(16, Day1.computeSimilarity(list1, list2));
    }

    @Test
    void givenExampleData_resultShouldBeCorrect() {
        long[] list1 = {3, 4, 2, 1, 3, 3};
        long[] list2 = {4, 3, 5, 3, 9, 3};
        assertEquals(31, Day1.computeSimilarity(list1, list2));
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
            assertEquals(23529853, Day1.computeSimilarity(list1, list2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
