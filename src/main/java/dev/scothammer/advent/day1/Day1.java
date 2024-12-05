package dev.scothammer.advent.day1;

import java.util.Arrays;

public class Day1 {
    public static long computeDiffs(long[] list1, long[] list2) {
        assert list1 != null && list2 != null : "Lists must not be null";
        long sum = 0;
        Arrays.sort(list1);
        Arrays.sort(list2);
        if (list1.length > 0 && list2.length > 0) {
            for (int i = 0; i < list1.length; i++) {
                sum += Math.abs(list1[i] - list2[i]);
            }
        }
        return sum;
    }
}
