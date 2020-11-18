package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

public class BowlingGameV7 {
    private ArrayList<FrameV7> frames = new ArrayList<>();
    private ArrayList<Integer> rolls = new ArrayList<>();
    private FrameV7 currentFrame;

    BowlingGameV7() {
        refreshFrame();
    }

    private void refreshFrame() {
        currentFrame = new FrameV7();
        frames.add(currentFrame);
    }

    public void roll(int pins) {
        rolls.add(pins);
        currentFrame.hitPins(pins);
        if (currentFrame.hasTwoRollPins()) {
            currentFrame.prepareCalRule(rolls);
            refreshFrame();
        }
    }

    public int score() {
        return frames.stream().mapToInt(FrameV7::score).sum();
    }
}
