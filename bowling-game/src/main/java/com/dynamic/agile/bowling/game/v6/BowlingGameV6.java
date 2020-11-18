package com.dynamic.agile.bowling.game.v6;

import java.util.ArrayList;

public class BowlingGameV6 {
    private ArrayList<FrameV6> frames = new ArrayList<>();
    private ArrayList<Integer> rolls = new ArrayList<>();
    private FrameV6 currentFrame;

    BowlingGameV6() {
        startNewFrame();
    }

    public void roll(int pins) {
        rolls.add(pins);
        refreshFrame(pins);
    }

    private void refreshFrame(int pins) {
        currentFrame.hitPins(pins);
        if (currentFrame.isFinished()) {
            currentFrame.prepareCalRule(rolls);
            startNewFrame();
        }
    }

    private void startNewFrame() {
        currentFrame = new FrameV6();
        frames.add(currentFrame);
    }

    public int score() {
        return frames.stream().mapToInt(FrameV6::score).sum();
    }
}
