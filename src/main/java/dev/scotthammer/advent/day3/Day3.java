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
            String group = matcher.group();
            instructions.add(new Instruction(group));
            startIndex = matcher.end();
        }

        return instructions.toArray(new Instruction[0]);
    }

    public static Instruction[] parseEnabledInstructions(String input) {
        Pattern pattern = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\(\\d{1,3},\\d{1,3}\\)");
        Matcher matcher = pattern.matcher(input);
        List<Instruction> instructions = new ArrayList<>();
        int startIndex = 0;
        boolean doing = true;
        while (matcher.find(startIndex)) {
            String group = matcher.group();
            startIndex = matcher.end();
            if (group.startsWith("do")) {
                doing = group.equals("do()") ;
                continue;
            }
            if (doing)
                instructions.add(new Instruction(group));
        }

        return instructions.toArray(new Instruction[0]);
    }
}
