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
        rollPins.add(pins);
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
        setScoreBoard();
        if (lessThan10Frames() && currentFrame.isFinish()) {
            createNewFrame();
        }
    }

    int score() {
        return frames.stream().mapToInt(FrameDAPV3::score).sum();
    }

    boolean isFinished() {
        return finished;
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

    String scoreBoard() {
        return scoreBoard;
    }

    private void setScoreBoard() {
        String currentRoll = "" + currentFrame.currentRoll();
        String frameRollPins = currentFrame.displayFrameRollPins();
        if (extraRoll1()) {
            if (currentFrame.isSpare()) {
                currentRoll = "/1";
                frameRollPins = displayLastRollPins();
            }
            if (currentFrame.isStrike()) {
                currentRoll = "x1";
                frameRollPins = displayLastRollPins();
            }
        }
        if (extraRoll2()) {
            currentRoll = "x2";
            frameRollPins = displayLastRollPins();
        }
        scoreBoard = frames.size() + "," + currentRoll + "," + frameRollPins + "," + score();
    }

    private boolean extraRoll2() {
        return lastRollIndexOfFrame10 != -1 && lastRollIndex() - lastRollIndexOfFrame10 == 2;
    }

    private boolean extraRoll1() {
        return lastRollIndexOfFrame10 != -1 && lastRollIndex() - lastRollIndexOfFrame10 == 1;
    }

    private String displayLastRollPins() {
        return lastRollPins() == 10 ? "x" : "" + lastRollPins();
    }

    private Integer lastRollPins() {
        return rollPins.get(lastRollIndex());
    }
}
