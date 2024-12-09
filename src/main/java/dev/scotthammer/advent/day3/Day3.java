package dev.scotthammer.advent.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day3 {
    private Day3() {}

    public static Instruction[] parseInstructions(String input) {
        Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        Matcher matcher = pattern.matcher(input);
        List<Instruction> instructions = new ArrayList<>();
        int startIndex = 0;
        while (matcher.find(startIndex)) {
            instructions.add(new Instruction(matcher.group()));
            startIndex = matcher.end();
        }

        return instructions.toArray(new Instruction[0]);
    }
}
