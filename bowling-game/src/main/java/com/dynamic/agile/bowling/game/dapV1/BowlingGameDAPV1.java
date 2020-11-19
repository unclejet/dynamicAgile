package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

public class BowlingGameDAPV1 {
    private ArrayList<FrameDAPV1> frames = new ArrayList<>();
    private ArrayList<Integer> rolls = new ArrayList<>();
    private FrameDAPV1 currentFrame;
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
        if (currentFrame.isFinished()) {
            currentFrame.setScoreRule(rolls);
            createNewFrame();
        }
    }

    public int score() {
        return frames.stream().mapToInt(FrameDAPV1::score).sum();
    }

    String scoreBoard() {
        return scoreBoard.showBoard();
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
            return frameIndex() > 10;
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
}
