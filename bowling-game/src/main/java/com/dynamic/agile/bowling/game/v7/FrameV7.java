package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class FrameV7 {
    private ArrayList<Integer> framePins = new ArrayList<>();
    private CalRule calRule;

    void hitPins(int pins) {
        framePins.add(pins);
    }

    boolean hasTwoRollPins() {
        return framePins.size() == 2;
    }

    void prepareCalRule(ArrayList<Integer> rolls) {
        if (isMiss()) {
            calRule = new MissRule(rolls);
        }
        if (isSpare()) {
            calRule = new SpareRule(rolls);
        }
    }

    int score() {
        return calRule != null ? calRule.score() : 0;
    }

    private boolean isMiss() {
        return hasTwoRollPins() && countTwoRollPins() < 10;
    }

    private boolean isSpare() {
        return hasTwoRollPins() && countTwoRollPins() == 10;
    }

    private int countTwoRollPins() {
        return framePins.get(0) + framePins.get(1);
    }

}
