package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class BowlingGameDAPV2 {
    private ArrayList<FrameDAPV2> frames = new ArrayList<>();
    void roll(int pins) {
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV2::score).sum();
    }
}
