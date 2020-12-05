package com.dynamic.agile.bowling.game.scoreboard.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:40
 * @description:
 */
public class BowlingGame {
    public static final int FRAMES_NUMBER_IN_GAME = 10;
    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame;
    private Frame addedFrame;

    private GameScoreBoard scoreBoard;

    private List<Integer> rolls = new ArrayList<>();

    public BowlingGame() {
        newFrame();
        scoreBoard = new GameScoreBoard();
    }

    public int score() {
        return frames.stream()
                .limit(FRAMES_NUMBER_IN_GAME)
                .mapToInt(Frame::score)
                .sum();
    }

    public void roll(int pins) {
        rolls.add(pins);
        currentFrame.hitPins(pins);
        if (currentFrame.isFinished()) {
            currentFrame.makeSureScoreRule(rolls);
            newFrame();
        }
    }

    private void newFrame() {
        currentFrame = new Frame();
        if (hasNextFrame()) {
            frames.add(currentFrame);
        } else if(addedFrame == null) {
            addedFrame = currentFrame;
        }

    }

    private boolean hasNextFrame() {
        return frames.size() < FRAMES_NUMBER_IN_GAME;
    }

    public String showScoreBoard() {
        return scoreBoard.generateContent();
    }

    private class GameScoreBoard {
        public String generateContent() {
            Frame frame = currentFrameNotStart() ? getLastFrame() : currentFrame;
            return String.format("%d, %s, %s, %d", getFrameIndex(frame), getRollIndex(frame), getHitPins(frame), score());
        }

        private String getHitPins(Frame frame) {
            return isAddedFrameNotStart() ? frame.getPins() : addedFrame.getPins();
        }

        private String getRollIndex(Frame frame) {
            return isAddedFrameNotStart() ? String.valueOf(frame.getRollIndex()) : "a" + addedFrame.getRollIndex() ;
        }

        private boolean isAddedFrameNotStart() {
            return addedFrame == null || addedFrame.getRollIndex() == 0;
        }

        private int getFrameIndex(Frame frame) {
            return isAddedFrameNotStart() ? indexOf(frame) : FRAMES_NUMBER_IN_GAME;
        }

        private int indexOf(Frame frame) {
            return frames.indexOf(frame) + 1;
        }

        private Frame getLastFrame() {
            return currentFrame == addedFrame ? frames.get(FRAMES_NUMBER_IN_GAME - 1) : frames.get(frames.size() - 2);
        }

        private boolean currentFrameNotStart() {
            return currentFrame.getRollIndex() == 0;
        }
    }
}
