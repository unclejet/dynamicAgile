package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class BowlingGameDAPV2 {
    private ArrayList<FrameDAPV2> frames = new ArrayList<>();
    void roll(int pins) {
        FrameDAPV2 frame = new FrameDAPV2();
        frame.hitPins(pins);
        frames.add(frame);
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV2::score).sum();
    }
}
