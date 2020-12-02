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

    private List<Integer> rolls = new ArrayList<>();

    public BowlingGame() {
        newFrame();
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
        frames.add(currentFrame);
    }

    public String showScoreBoard() {
        Frame frame = currentFrameNotStart() ? getLastFrame() : currentFrame;
        return String.format("%d, %s, %s, %d", getFrameIndex(frame), getRollIndex(frame), frame.getPins(), score());
    }

    private String getRollIndex(Frame frame) {
        int rollIndex = frame.getRollIndex();
        return indexOf(frame) > FRAMES_NUMBER_IN_GAME ? "a" + rollIndex : String.valueOf(rollIndex);
    }

    private int getFrameIndex(Frame frame) {
        int index = indexOf(frame);
        return index > FRAMES_NUMBER_IN_GAME ? FRAMES_NUMBER_IN_GAME : index;
    }

    private int indexOf(Frame frame) {
        return frames.indexOf(frame) + 1;
    }

    private Frame getLastFrame() {
        return frames.get(frames.size() - 2);
    }

    private boolean currentFrameNotStart() {
        return currentFrame.getRollIndex() == 0;
    }
}
