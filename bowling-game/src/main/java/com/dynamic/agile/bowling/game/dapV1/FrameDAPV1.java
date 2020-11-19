package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

class FrameDAPV1 {
    public static final int PINS_OF_FRAME = 10;
    private ArrayList<Integer> hitPins = new ArrayList<>();

    int score() {
        if (isSpare()) {
            return 0;
        }
        return hasTwoRolls() ? countTwoRollPins() : 0;
    }

    private boolean isSpare() {
        return hasTwoRolls() && countTwoRollPins() == PINS_OF_FRAME;
    }

    private int countTwoRollPins() {
        return hitPins.get(0) + hitPins.get(1);
    }

    void hitPins(int pins) {
        hitPins.add(pins);
    }

    boolean hasTwoRolls() {
        return hitPins.size() == 2;
    }
}
