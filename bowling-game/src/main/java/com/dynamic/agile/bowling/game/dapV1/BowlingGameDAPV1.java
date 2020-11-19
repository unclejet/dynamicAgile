package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

public class BowlingGameDAPV1 {
    private static final int FRAMES_OF_GAME = 10;
    private ArrayList<FrameDAPV1> frames = new ArrayList<>();
    private ArrayList<Integer> rolls = new ArrayList<>();
    private FrameDAPV1 currentFrame;
    private FinishRule finishRule = new FinishRule();
    private ScoreBoard scoreBoard = new ScoreBoard();

    BowlingGameDAPV1() {
        createNewFrame();
    }

    private void createNewFrame() {
        currentFrame = new FrameDAPV1();
        frames.add(currentFrame);
    }

    public void roll(int pins) {
        rolls.add(pins);
        currentFrame.hitPins(pins);
        finishRule.checkFinishForExtraRoll();
        if (currentFrame.isFinished()) {
            currentFrame.setScoreRule(rolls);
            finishRule.checkFinishWhenFrame10();
            createNewFrame();
        }
    }

    public int score() {
        return frames.stream().mapToInt(FrameDAPV1::score).sum();
    }

    String scoreBoard() {
        return scoreBoard.showBoard();
    }

    boolean isFinished() {
        return finishRule.finished;
    }

    private class ScoreBoard {
        String showBoard() {
            return showFrameIndex() + "," + frameRollIndex() + "," + showHitPins() + "," + score();
        }

        private String showFrameIndex() {
            return appendixRoll() ? "-" : String.valueOf(frameIndex());
        }

        private String showHitPins() {
            return appendixRoll() ? lastRollPins() : workingFrame().showHitPins();
        }

        private String lastRollPins() {
            return String.valueOf(rolls.get(rolls.size() - 1));
        }

        private String frameRollIndex() {
            return appendixRoll() ? "-" : workingFrame().frameRollIndex();
        }

        private boolean appendixRoll() {
            return frameIndex() > FRAMES_OF_GAME;
        }

        private FrameDAPV1 workingFrame() {
            return frames.get(frameIndex() - 1);
        }

        private int frameIndex() {
            return lastFrame().isNew() ? frames.size() - 1 : frames.size();
        }

        private FrameDAPV1 lastFrame() {
            return frames.get(frames.size() - 1);
        }
    }

    private class FinishRule {
        private boolean finished;
        private int frame10RollIndex = 0;
        private boolean oneMoreRoll;
        private boolean twoMoreRolls;

        private void addTwoMoreRolls() {
            twoMoreRolls = true;
            frame10RollIndex = rolls.size() - 1;
        }

        private void addOneMoreRoll() {
            oneMoreRoll = true;
        }

        void checkFinishWhenFrame10() {
            if (frames.size() == 10) {
                FrameDAPV1 frame10 = frames.get(10 - 1);
                if (frame10.isMiss()) {
                    finished = true;
                }
                if (frame10.isSpare()) {
                    addOneMoreRoll();
                }
                if (frame10.isStrike()) {
                    addTwoMoreRolls();
                }
            }
        }
        private void checkFinishForExtraRoll() {
            if (oneMoreRoll) {
                finished = true;
            } else if (twoMoreRolls && rolls.size() - 1 - frame10RollIndex == 2) {
                finished = true;
            }
        }
    }
}
