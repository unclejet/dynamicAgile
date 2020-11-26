package com.dynamic.agile.bowling.game.dapV3;

import java.util.ArrayList;

class BowlingGameDAPV3 {
    private static final int FRAMES_OF_GAME = 10;
    private ArrayList<FrameDAPV3> frames = new ArrayList<>(10);
    private ArrayList<Integer> rollPins = new ArrayList<>();
    private FrameDAPV3 currentFrame;
    private boolean finished;
    private boolean oneMoreRoll;
    private boolean twoMoreRolls;
    private int lastRollIndexOfFrame10;

    BowlingGameDAPV3() {
        createNewFrame();
    }

    void roll(int pins) {
        rollPins.add(pins);
        checkExtraRoll();
        if (lessThan10Frames()) {
            frameRoll(pins);
        } else if (alreadyHas10Frames() && !currentFrame.isFinish()) {
            frameRoll(pins);
        }
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV3::score).sum();
    }

    boolean isFinished() {
        return finished;
    }

    private void createNewFrame() {
        if (lessThan10Frames()) {
            currentFrame = new FrameDAPV3();
            frames.add(currentFrame);
        }
    }

    private void checkExtraRoll() {
        if (oneMoreRoll) {
            finished = true;
        }
        if (twoMoreRolls && lastRollIndex() - lastRollIndexOfFrame10 == 2) {
            finished = true;
        }
    }

    private void frameRoll(int pins) {
        currentFrame.hitPins(pins);
        if (currentFrame.isFinish()) {
            currentFrame.setRollPins(rollPins);
            createNewFrame();
            checkGameFinish();
        }
    }

    private void checkGameFinish() {
        if (alreadyHas10Frames() && currentFrame.isFinish()) {
            if (currentFrame.isMiss()) {
                finished = true;
            }
            if (currentFrame.isSpare()) {
                oneMoreRoll = true;
            }
            if (currentFrame.isStrike()) {
                twoMoreRolls = true;
                lastRollIndexOfFrame10 = lastRollIndex();
            }
        }
    }

    private int lastRollIndex() {
        return rollPins.size() - 1;
    }

    private boolean lessThan10Frames() {
        return frames.size() < FRAMES_OF_GAME;
    }

    private boolean alreadyHas10Frames() {
        return frames.size() == FRAMES_OF_GAME;
    }

}
