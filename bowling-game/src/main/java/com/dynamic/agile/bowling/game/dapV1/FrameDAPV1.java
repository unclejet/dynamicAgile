package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

class FrameDAPV1 {
    private ArrayList<Integer> hitPins = new ArrayList<>();

    int score() {
        return hitPins.size() == 2 ? hitPins.stream().mapToInt(Integer::intValue).sum() : 0;
    }

    void hitPins(int pins) {
        hitPins.add(pins);
    }
}