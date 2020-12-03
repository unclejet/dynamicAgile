package com.dynamic.agile.bowling.game.dapV3;

import java.util.ArrayList;

class BowlingGameDAPV3 {
    private static final int FRAMES_OF_GAME = 10;
    public static final String ExtraRoll = "a";
    private ArrayList<FrameDAPV3> frames = new ArrayList<>(10);
    private ArrayList<Integer> rollPins = new ArrayList<>();
    private FrameDAPV3 frame;

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
        String currentRoll = extraRoll1() || extraRoll2() ? displayExtraRoll() : String.valueOf(frame.rollTimes());
        String frameRollPins = extraRoll1() || extraRoll2() ? displayLastRollPins() : frame.displayFrameRollPins();
        scoreBoard = String.format("%d,%s,%s,%d,%b", frames.size(), currentRoll, frameRollPins, score(), isFinished());
    }

    private String displayExtraRoll() {
        return ExtraRoll + extraRollIndex();
    }

    private void addRollPins(int pins) {
        rollPins.add(pins);
    }

    private void createNewFrameIfLessThan10Frames() {
        if (lessThan10Frames() && frame.isFinish()) {
            createNewFrame();
        }
    }

    private void frameRollAndCheckFinish(int pins) {
        if (alreadyHas10Frames()) {
            if (isExtraRoll()) {
                checkGameFinishWhenExtraRoll();
            } else {
                frameRoll(pins);
                checkGameFinish();
            }
        } else {
            frameRoll(pins);
        }
    }

    private void createNewFrame() {
        frame = new FrameDAPV3();
        frames.add(frame);
    }

    private void checkGameFinishWhenExtraRoll() {
        if (extraRoll1() && frame.isSpare()) {
            finished = true;
        }
        if (extraRoll2() && frame.isStrike()) {
            finished = true;
        }
    }

    private void frameRoll(int pins) {
        frame.hitPins(pins);
        if (frame.isFinish()) {
            frame.setRollPins(rollPins);
        }
    }

    private void checkGameFinish() {
        if (frame.isMiss()) {
            finished = true;
        }
        if (frame.isSpare() || frame.isStrike()) {
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

    private boolean isExtraRoll() {
        return alreadyHas10Frames() && lastRollIndexOfFrame10 != -1;
    }

    private boolean extraRoll1() {
        return isExtraRoll() && extraRollIndex() == 1;
    }

    private int extraRollIndex() {
        return lastRollIndex() - lastRollIndexOfFrame10;
    }

    private boolean extraRoll2() {
        return isExtraRoll() && extraRollIndex() == 2;
    }

    private String displayLastRollPins() {
        return lastRollPins() == FrameDAPV3.PINS_OF_FRAME ? FrameDAPV3.STRIKE : String.valueOf(lastRollPins());
    }

    private int lastRollPins() {
        return rollPins.get(lastRollIndex());
    }
}