package dev.scotthammer.advent.day2;

import java.util.Arrays;

class Day2 {
    private Day2() {
    }

    public static boolean isReportSafe(int[] report) {
        boolean safe = true;
        int savedDirection = 0;
        for (int i = 0; i < report.length - 1; i++) {
            int rawDiff = report[i] - report[i + 1];
            if (rawDiff == 0) {
                safe = false;
            } else {
                int absDiff = Math.abs(rawDiff);
                int direction = rawDiff / absDiff;
                if (savedDirection == 0) savedDirection = direction;
                safe = (absDiff <= 3) && (direction == savedDirection);
            }
            if (!safe) break;
        }
        return safe;
    }

    public static long countSafeReports(String[] reports) {
        return Arrays.stream(reports).
                map(reportStr ->
                        Arrays.stream(reportStr.split("\\s+"))
                                .mapToInt(Integer::parseInt).toArray()
                ).filter(Day2::isReportSafe)
                .count();
    }
}
