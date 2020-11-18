package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class FrameV7 {
    private ArrayList<Integer> framePins = new ArrayList<>();

    int score() {
        if (isMiss()) {
            return countTwoRollPins();
        }
        if (isSpare()) {
            return 0;
        }
        return 0;
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

    void hitPins(int pins) {
        framePins.add(pins);
    }

    boolean hasTwoRollPins() {
        return framePins.size() == 2;
    }
}
