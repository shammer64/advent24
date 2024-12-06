package day1;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

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
        assertThrows(AssertionError.class,
                () -> Day1.sumOfDiffs(list1, list2));
    }

    @Test
    @SuppressWarnings("nullness")
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
        assertEquals(11, sum);
    }

    @Test
    public void givenTwoUnsortedTwoItemLists_sumOfDiffsIsDiffOfItems() {
        long[] list1 = {21L, 15L};
        long[] list2 = {8L, 17L};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(11, sum);
    }

    @Test
    public void givenSampleData_sumOfDiffsIsEleven() {
        long[] list1 = {3, 4, 2, 1, 3, 3};
        long[] list2 = {4, 3, 5, 3, 9, 3};
        long sum = Day1.sumOfDiffs(list1, list2);
        assertEquals(11, sum);
    }

    @Test
    public void givenDay1Input_computeAnswer() {
        URL inputFileURL = ClassLoader.getSystemResource("day1_input.txt");

        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFileURL.getFile()))) {
            List<String[]> values = fileReader.lines()
                    .map(line -> line.split("\\s+"))
                    .toList();
            long[] list1 = values.stream()
                    .map(arr -> Long.parseLong(arr[0]))
                    .mapToLong(Long::longValue)
                    .toArray();
            long[] list2 = values.stream().map(arr -> Long.parseLong(arr[arr.length - 1]))
                    .mapToLong(Long::longValue)
                    .toArray();
            long sum = Day1.sumOfDiffs(list1, list2);
            assertEquals(1388114, sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static class Day1 {
        public static long sumOfDiffs(long[] list1, long[] list2) {
            assert list1 != null && list2 != null : "Lists must not be null";
            assert list1.length == list2.length : "Lists must be of equal length";
            long sum = 0;
            Arrays.sort(list1);
            Arrays.sort(list2);
            for (int i = 0; i < list1.length; i++) {
                sum += Math.abs(list1[i] - list2[i]);
            }
            return sum;
        }
    }
}
