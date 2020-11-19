package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class FrameDAPV2 {
    private ArrayList<Integer> hitPins = new ArrayList<>();
    int score() {
        return hitPins.stream().mapToInt(Integer::intValue).sum();
    }

    void hitPins(int pins) {
        hitPins.add(pins);
    }
}
