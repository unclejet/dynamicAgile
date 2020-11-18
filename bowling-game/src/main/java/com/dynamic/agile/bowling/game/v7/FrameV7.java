package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

public class FrameV7 {
    private ArrayList<Integer> framePins = new ArrayList<>();

    public int score() {
        return framePins.size() == 2 ? framePins.get(0) + framePins.get(1) : 0;
    }

    void hitPins(int pins) {
        framePins.add(pins);
    }
}
