package com.dynamic.agile.bowling.game.gamescore.v4;

import java.util.ArrayList;

public class FrameV4 {
    public static final int PINS_OF_FRAMES = 10;
    private ArrayList<Integer> frameRolls = new ArrayList<>(2);
    private int lastRollIndex = -1;

    public void roll(int pins, int rollIndex) {
        frameRolls.add(pins);
        lastRollIndex = rollIndex;
    }

    public boolean isFinished() {
        return isStrike() || hasTwoRolls();
    }

    public int score(ArrayList<Integer> rolls) {
        if (isStrike()) {
            return PINS_OF_FRAMES + rolls.get(lastRollIndex + 1) + rolls.get(lastRollIndex + 2);
        }
        if (isSpare()) {
            return PINS_OF_FRAMES + rolls.get(lastRollIndex + 1);
        }
        return firstRoll() + secondRoll();
    }

    private boolean isSpare() {
        return firstRoll() + secondRoll() == PINS_OF_FRAMES;
    }

    private Integer secondRoll() {
        return frameRolls.get(1);
    }

    private Integer firstRoll() {
        return frameRolls.get(0);
    }

    private boolean hasTwoRolls() {
        return frameRolls.size() == 2;
    }

    private boolean isStrike() {
        return firstRoll() == 10;
    }

}
