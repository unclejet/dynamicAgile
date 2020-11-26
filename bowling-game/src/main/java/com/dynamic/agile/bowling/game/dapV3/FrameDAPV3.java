package com.dynamic.agile.bowling.game.dapV3;

import java.util.ArrayList;

class FrameDAPV3 {
    public static final int PINS_OF_FRAME = 10;
    private static final int SCORE_NOT_READY_TO_COUNT = 0;
    private ArrayList<Integer> hitPins = new ArrayList<>();
    private ArrayList<Integer> rollPins;
    private int frameLastRollIndex;


    void hitPins(int pins) {
        hitPins.add(pins);
    }

    boolean isFinish() {
        return isStrike() || hasTwoRolls();
    }

    void setRollPins(ArrayList<Integer> rollPins) {
        this.rollPins = rollPins;
        frameLastRollIndex = lastRollIndex();
    }

    int score() {
        if (isStrike() && hasNext2Rolls()) {
            return PINS_OF_FRAME + next2RollPins();
        }
        if (isSpare() && hasNextRoll()) {
            return PINS_OF_FRAME + nextRollPins();
        }
        if (isMiss()) {
            return countFrameTwoRollPins();
        }
        return SCORE_NOT_READY_TO_COUNT;
    }

    private int next2RollPins() {
        return rollPins.get(frameLastRollIndex + 1) + rollPins.get(frameLastRollIndex + 2);
    }

    private boolean hasNext2Rolls() {
        return lastRollIndex() >= frameLastRollIndex + 2;
    }

    private boolean hasNextRoll() {
        return lastRollIndex() >= frameLastRollIndex + 1;
    }

    private int lastRollIndex() {
        return rollPins.size() - 1;
    }

    private int nextRollPins() {
        return rollPins.get(frameLastRollIndex + 1);
    }

    boolean isMiss() {
        return hasTwoRolls() && countFrameTwoRollPins() < PINS_OF_FRAME;
    }

    boolean isSpare() {
        return hasTwoRolls() && countFrameTwoRollPins() == PINS_OF_FRAME;
    }

    boolean isStrike() {
        return hitPins.size() == 1 && hitPins.get(0) == PINS_OF_FRAME;
    }

    private int countFrameTwoRollPins() {
        return hitPins.get(0) + hitPins.get(1);
    }

    private boolean hasTwoRolls() {
        return hitPins.size() == 2;
    }
}
