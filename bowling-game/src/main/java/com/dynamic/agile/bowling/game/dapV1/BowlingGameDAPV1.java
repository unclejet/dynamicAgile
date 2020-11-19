package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

public class BowlingGameDAPV1 {
    private ArrayList<FrameDAPV1> frames = new ArrayList<>();
    public void roll(int pins) {
    }

    public int score() {
        return frames.stream().mapToInt(FrameDAPV1::score).sum();
    }
}
