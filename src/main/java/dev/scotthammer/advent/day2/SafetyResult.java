package dev.scotthammer.advent.day2;

public class SafetyResult {
    private final boolean safe;
    private final int unsafeIndex;

    public SafetyResult(boolean safe, int unsafeIndex) {
        this.safe = safe;
        this.unsafeIndex = unsafeIndex;
    }

    public boolean isSafe() {
        return safe;
    }

    public int getUnsafeIndex() {
        return unsafeIndex;
    }
}
