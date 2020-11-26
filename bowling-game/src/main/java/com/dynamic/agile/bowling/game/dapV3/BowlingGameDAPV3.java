package com.dynamic.agile.bowling.game.dapV3;

import java.util.ArrayList;

class BowlingGameDAPV3 {
    private ArrayList<FrameDAPV3> frames = new ArrayList<>();
    private ArrayList<Integer> rollPins = new ArrayList<>();
    private FrameDAPV3 currentFrame;
    BowlingGameDAPV3() {
        createNewFrame();
    }

    private void createNewFrame() {
        currentFrame = new FrameDAPV3();
        frames.add(currentFrame);
    }

    void roll(int pins) {
        rollPins.add(pins);
        currentFrame.hitPins(pins);
        if(currentFrame.isFinish()){
            currentFrame.setRollPins(rollPins);
            createNewFrame();
        }
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV3::score).sum();
    }
}
