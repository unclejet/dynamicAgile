package com.dynamic.agile.bowling.game.dapV3;

import java.util.ArrayList;

class BowlingGameDAPV3 {
    private static final int FRAMES_OF_GAME = 10;
    private ArrayList<FrameDAPV3> frames = new ArrayList<>(10);
    private ArrayList<Integer> rollPins = new ArrayList<>();
    private FrameDAPV3 currentFrame;

    BowlingGameDAPV3() {
        createNewFrame();
    }

    private void createNewFrame() {
        if (lessThan10Frames()) {
            currentFrame = new FrameDAPV3();
            frames.add(currentFrame);
        }
    }

    void roll(int pins) {
        rollPins.add(pins);
        if (lessThan10Frames()) {
            frameRoll(pins);
        } else if (alreadyHas10Frames() && !currentFrame.isFinish()) {
            frameRoll(pins);
        }
    }

    private void frameRoll(int pins) {
        currentFrame.hitPins(pins);
        if (currentFrame.isFinish()) {
            currentFrame.setRollPins(rollPins);
            createNewFrame();
        }
    }

    private boolean lessThan10Frames() {
        return frames.size() < FRAMES_OF_GAME;
    }

    private boolean alreadyHas10Frames() {
        return frames.size() == FRAMES_OF_GAME;
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV3::score).sum();
    }
}
