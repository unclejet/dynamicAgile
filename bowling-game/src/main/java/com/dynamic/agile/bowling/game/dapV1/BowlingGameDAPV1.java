package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

public class BowlingGameDAPV1 {
    private ArrayList<FrameDAPV1> frames = new ArrayList<>();
    private FrameDAPV1 currentFrame;

    public BowlingGameDAPV1() {
        currentFrame = new FrameDAPV1();
        frames.add(currentFrame);
    }

    public void roll(int pins) {
        currentFrame.hitPins(pins);
    }

    public int score() {
        return frames.stream().mapToInt(FrameDAPV1::score).sum();
    }
}
