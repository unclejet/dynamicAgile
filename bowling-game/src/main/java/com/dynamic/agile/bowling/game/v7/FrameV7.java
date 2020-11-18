package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class FrameV7 {
    private ArrayList<Integer> framePins = new ArrayList<>();

    int score() {
        return hasTwoRollPins() ? framePins.get(0) + framePins.get(1) : 0;
    }

    void hitPins(int pins) {
        framePins.add(pins);
    }

    boolean hasTwoRollPins() {
        return framePins.size() == 2;
    }
}
