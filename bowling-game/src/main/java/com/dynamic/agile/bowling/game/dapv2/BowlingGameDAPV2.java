package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class BowlingGameDAPV2 {
    private ArrayList<FrameDAPV2> frames = new ArrayList<>();
    private FrameDAPV2 frame;

    public BowlingGameDAPV2() {
        frame = new FrameDAPV2();
        frames.add(frame);
    }

    void roll(int pins) {
        frame.hitPins(pins);
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV2::score).sum();
    }
}
