package com.dynamic.agile.bowling.game.scoreboard.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:40
 * @description:
 */
public class BowlingGame {
    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame;

    private List<Integer> rolls = new ArrayList<>();

    public BowlingGame() {
        newFrame();
    }

    public int score() {
        return frames.stream().mapToInt(Frame::score).sum();
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
        return String.format("%d, %s, %s, %d", frames.size(), currentFrame.getRollIndex(), currentFrame.getPins(), score());
    }
}
