package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class FrameDAPV2 {
    private ArrayList<Integer> hitPins = new ArrayList<>();

    int score() {
        return hasTwoRolls() ? hitPins.get(0) + hitPins.get(1) : 0;
    }

    private boolean hasTwoRolls() {
        return hitPins.size() == 2;
    }

    void hitPins(int pins) {
        hitPins.add(pins);
    }
}
