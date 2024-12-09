package dev.scotthammer.advent.day3;

class Instruction {
    private final long arg1;
    private final long arg2;

    public Instruction(String instructionCode) {
        String[] args = instructionCode.split("\\D+");
        this.arg1 = Long.parseLong(args[1]);
        this.arg2 = Long.parseLong(args[2]);
    }

    public long calculate() {
        return arg1 * arg2;
    }
}
