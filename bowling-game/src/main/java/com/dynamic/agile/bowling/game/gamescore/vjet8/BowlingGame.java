package com.dynamic.agile.bowling.game.gamescore.vjet8;

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
        return frames.stream().mapToInt(frame -> frame.score(rolls)).sum();
    }

    public void roll(int pins) {
        rolls.add(pins);
        if (currentFrame.isFinished()) {
            currentFrame.setLastRollIndex(rolls.size() - 2);
            newFrame();
        }
        currentFrame.hitPins(pins);
    }

    private void newFrame() {
        currentFrame = new Frame();
        frames.add(currentFrame);
    }
}
