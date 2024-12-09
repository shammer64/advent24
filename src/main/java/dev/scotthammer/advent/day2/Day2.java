package dev.scotthammer.advent.day2;

import java.util.Arrays;
import java.util.function.Predicate;

class Day2 {
    private Day2() {
    }

    public static boolean isReportSafe(int[] report) {
        return checkSafetyOfReport(report).isSafe();
    }

    private static SafetyResult checkSafetyOfReport(int[] report) {
        boolean safe = true;
        int unsafeIndex = -1;
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
            if (!safe) {
                unsafeIndex = i;
                break;
            }
        }
        return new SafetyResult(safe, unsafeIndex);
    }

    public static long countSafeReports(String[] reports) {
        return Arrays.stream(reports).
                map(reportStr ->
                        Arrays.stream(reportStr.split("\\s+"))
                                .mapToInt(Integer::parseInt).toArray()
                ).filter(Day2::isReportSafe)
                .count();
    }

    public static boolean isReportSafeWithDampener(int[] report) {
        SafetyResult result = checkSafetyOfReport(report);
        boolean isSafe = result.isSafe();
        if (!isSafe) {
            int unsafeIndex = result.getUnsafeIndex();
            int[] reportCopy0 = null;
            if (unsafeIndex > 0)
                reportCopy0 = stripUnsafeIndex(report, unsafeIndex - 1);
            int[] reportCopy1 = stripUnsafeIndex(report, unsafeIndex);
            int[] reportCopy2 = stripUnsafeIndex(report, unsafeIndex + 1);
            isSafe = (reportCopy0 != null && checkSafetyOfReport(reportCopy0).isSafe())
                    || checkSafetyOfReport(reportCopy1).isSafe()
                    || checkSafetyOfReport(reportCopy2).isSafe();
        }
        System.out.println((isSafe ? "Safe: " : "Unsafe: ") + Arrays.toString(report));
        return isSafe;
    }

    private static int[] stripUnsafeIndex(int[] report, int unsafeIndex) {
        int[] reportCopy = new int[report.length - 1];
        System.arraycopy(report, 0, reportCopy, 0, unsafeIndex);
        System.arraycopy(report, unsafeIndex + 1, reportCopy, unsafeIndex, report.length - unsafeIndex - 1);
        return reportCopy;
    }

    public static long countSafeReports(String[] reports, Predicate<? super int[]> filterMethod) {
        return Arrays.stream(reports).
                map(reportStr ->
                        Arrays.stream(reportStr.split("\\s+"))
                                .mapToInt(Integer::parseInt).toArray()
                ).filter(filterMethod)
                .count();
    }
}
