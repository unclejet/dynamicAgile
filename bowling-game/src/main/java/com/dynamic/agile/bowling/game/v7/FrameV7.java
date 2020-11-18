package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class FrameV7 {

    public static final int PINS_OF_FRAME = 10;
    private ArrayList<Integer> framePins = new ArrayList<>();
    private CalRule calRule;

    void hitPins(int pins) {
        framePins.add(pins);
    }

    boolean isFinished() {
        return isStrike() || hasTwoRollPins();
    }

    void prepareCalRule(ArrayList<Integer> rolls) {
        if (isMiss()) {
            calRule = new MissRule(rolls);
        }
        if (isSpare()) {
            calRule = new SpareRule(rolls);
        }
        if (isStrike()) {
            calRule = new StrikeRule(rolls);
        }
    }

    int score() {
        return calRule != null ? calRule.score() : 0;
    }

    private boolean hasTwoRollPins() {
        return framePins.size() == 2;
    }

    private boolean isMiss() {
        return hasTwoRollPins() && countTwoRollPins() < PINS_OF_FRAME;
    }

    private boolean isSpare() {
        return hasTwoRollPins() && countTwoRollPins() == PINS_OF_FRAME;
    }

    private int countTwoRollPins() {
        return framePins.get(0) + framePins.get(1);
    }

    private boolean isStrike() {
        return framePins.get(0) == PINS_OF_FRAME;
    }
}
