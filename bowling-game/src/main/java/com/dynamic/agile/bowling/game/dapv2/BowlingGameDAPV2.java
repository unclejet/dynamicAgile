package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class BowlingGameDAPV2 {
    private ArrayList<FrameDAPV2> frames = new ArrayList<>();
    private ArrayList<Integer> rollPins = new ArrayList<>();
    private FrameDAPV2 frame;

    BowlingGameDAPV2() {
        createNewFrame();
    }

    private void createNewFrame() {
        frame = new FrameDAPV2();
        frames.add(frame);
    }

    void roll(int pins) {
        frame.hitPins(pins);
        rollPins.add(pins);
        if(frame.hasTwoRolls()){
            createNewFrame();
        }
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV2::score).sum();
    }
}
