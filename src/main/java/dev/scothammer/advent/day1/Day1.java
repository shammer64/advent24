package dev.scothammer.advent.day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static long computeSimilarity(long[] list1, long[] list2) {
        long similarity = 0;
        Map<Long, Long> map = new HashMap<>();
        for (long value : list2) {
            map.put(value, map.getOrDefault(value, 0L) + 1);
        }

        for (long value : list1) {
            if (map.containsKey(value)) {
                similarity += value * map.getOrDefault(value, 0L);
            }
        }
        return similarity;
    }
}
