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

    public BowlingGame() {
        newFrame();
    }

    public int score() {
        return frames.stream().mapToInt(Frame::score).sum();
    }

    public void roll(int pins) {
        if (currentFrame.isFinished()) {
            newFrame();
        }
        currentFrame.hitPins(pins);
    }

    private void newFrame() {
        currentFrame = new Frame();
        frames.add(currentFrame);
    }
}
