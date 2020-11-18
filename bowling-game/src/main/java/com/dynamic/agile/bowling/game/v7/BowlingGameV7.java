package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

public class BowlingGameV7 {
    private ArrayList<FrameV7> frames = new ArrayList<>();
    private ArrayList<Integer> rolls = new ArrayList<>();
    private FrameV7 currentFrame;

    BowlingGameV7() {
        createNewFrame();
    }

    private void createNewFrame() {
        currentFrame = new FrameV7();
        frames.add(currentFrame);
    }

    public void roll(int pins) {
        rolls.add(pins);
        refreshFrameAfterEachRoll(pins);
    }

    private void refreshFrameAfterEachRoll(int pins) {
        currentFrame.hitPins(pins);
        if (currentFrame.isFinished()) {
            currentFrame.prepareCalRule(rolls);
            createNewFrame();
        }
    }

    public int score() {
        return frames.stream().mapToInt(FrameV7::score).sum();
    }
}
