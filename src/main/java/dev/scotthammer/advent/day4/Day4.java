package dev.scotthammer.advent.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
    private Day4() {}

    private static final String XMAS = "(XMAS|SAMX)";
    private static final Pattern XMAS_PATTERN = Pattern.compile(XMAS);

    public static long countXmas(String[] input) {
        long count = 0;
        count += getHorizontalCount(input);
        count += getVerticalCount(input);
        count += getDiagonalRightCount(input);
        count += getDiagonalLeftCount(input);
        return count;
    }

    private static long getDiagonalLeftCount(String[] input) {
        int width = input[0].length();
        int height = input.length;
        int count = 0;
        if (width < 4 || height < 4) return count;

        for (int x = width - 1; x >= 0; x--) {
            StringBuilder diag = new StringBuilder();
            for (int y = 0; y < height && x - y >= 0; y++) {
                diag.append(input[y].charAt(x - y));
            }
            count += getXmasCount(diag.toString());
        }

        for (int y = 1; y < height; y++) {
            StringBuilder diag = new StringBuilder();
            for (int x = width - 1; x >= y; x--) {
                diag.append(input[height - x + y - 1].charAt(x));
            }
            count += getXmasCount(diag.toString());

        }
        return count;
    }

    private static long getDiagonalRightCount(String[] input) {
        int width = input[0].length();
        int height = input.length;
        int count = 0;
        if (width < 4 || height < 4) return count;

        for (int x = 0; x < width; x++) {
            StringBuilder diag = new StringBuilder();
            for (int y = 0; y < height - x && x + y < width; y++) {
                diag.append(input[y].charAt(x + y));
            }
            count += getXmasCount(diag.toString());
        }

        for (int y = 1; y < height; y++) {
            StringBuilder diag = new StringBuilder();
            for (int x = 0; x < width - y && x + y < height; x++) {
                diag.append(input[x + y].charAt(x));
            }
            count += getXmasCount(diag.toString());
        }
        return count;
    }

    private static long getVerticalCount(String[] input) {
        int count = 0;
        for (int i = 0; i < input[0].length(); i++) {
            StringBuilder column = new StringBuilder();
            for (String line : input) {
                column.append(line.charAt(i));
            }
            if (column.length() >= 4)
                count += getXmasCount(column.toString());
        }
        return count;
    }

    private static long getHorizontalCount(String[] input) {
        long count = 0;
        for (String row : input) {
            if (row.length() >= 4) {
                count += getXmasCount(row);
            }
        }
        return count;
    }

    private static int getXmasCount(String input) {
        Matcher matcher = XMAS_PATTERN.matcher(input);
        int index = 0;
        int count = 0;
        while (matcher.find(index)) {
            index = matcher.end() - 1;
            count++;
        }
        return count;
    }
}
