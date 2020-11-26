package com.dynamic.agile.bowling.game.dapV3;

import java.util.ArrayList;

class BowlingGameDAPV3 {
    private static final int FRAMES_OF_GAME = 10;
    private ArrayList<FrameDAPV3> frames = new ArrayList<>(10);
    private ArrayList<Integer> rollPins = new ArrayList<>();
    private FrameDAPV3 currentFrame;

    private boolean finished;
    private int lastRollIndexOfFrame10 = -1;
    private String scoreBoard;

    BowlingGameDAPV3() {
        createNewFrame();
    }

    void roll(int pins) {
        addRollPins(pins);
        frameRollAndCheckFinish(pins);
        displayScoreBoard();
        createNewFrameIfLessThan10Frames();
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV3::score).sum();
    }

    boolean isFinished() {
        return finished;
    }

    String scoreBoard() {
        return scoreBoard;
    }

    private void displayScoreBoard() {
        String currentRollAndPins = currentFrame.currentRoll() + "," +
                currentFrame.displayFrameRollPins();
        if (extraRoll1()) {
            currentRollAndPins = "a1," + displayLastRollPins();
        }
        if (extraRoll2()) {
            currentRollAndPins = "a2," + displayLastRollPins();
        }
        scoreBoard = frames.size() + "," + currentRollAndPins + "," + score();
    }

    private void addRollPins(int pins) {
        rollPins.add(pins);
    }

    private void createNewFrameIfLessThan10Frames() {
        if (lessThan10Frames() && currentFrame.isFinish()) {
            createNewFrame();
        }
    }

    private void frameRollAndCheckFinish(int pins) {
        if (alreadyHas10Frames()) {
            if (currentFrame.isFinish()) {
                checkExtraRoll();
            } else {
                frameRoll(pins);
                checkGameFinish();
            }
        } else {
            frameRoll(pins);
        }
    }

    private void createNewFrame() {
        currentFrame = new FrameDAPV3();
        frames.add(currentFrame);
    }

    private void checkExtraRoll() {
        if (extraRoll1() && currentFrame.isSpare()) {
            finished = true;
        }
        if (extraRoll2() && currentFrame.isStrike()) {
            finished = true;
        }
    }

    private void frameRoll(int pins) {
        currentFrame.hitPins(pins);
        if (currentFrame.isFinish()) {
            currentFrame.setRollPins(rollPins);
        }
    }

    private void checkGameFinish() {
        if (currentFrame.isMiss()) {
            finished = true;
        }
        if (currentFrame.isSpare() || currentFrame.isStrike()) {
            lastRollIndexOfFrame10 = lastRollIndex();
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

    private boolean extraRoll2() {
        return lastRollIndexOfFrame10 != -1 && lastRollIndex() - lastRollIndexOfFrame10 == 2;
    }

    private boolean extraRoll1() {
        return lastRollIndexOfFrame10 != -1 && lastRollIndex() - lastRollIndexOfFrame10 == 1;
    }

    private String displayLastRollPins() {
        return lastRollPins() == FrameDAPV3.PINS_OF_FRAME ? "x" : "" + lastRollPins();
    }

    private Integer lastRollPins() {
        return rollPins.get(lastRollIndex());
    }
}
