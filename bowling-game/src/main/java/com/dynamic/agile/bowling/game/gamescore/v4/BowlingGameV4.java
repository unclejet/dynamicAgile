package com.dynamic.agile.bowling.game.gamescore.v4;

import java.util.ArrayList;

public class BowlingGameV4 {
    private ArrayList<FrameV4> frames = new ArrayList<FrameV4>(10);
    private FrameV4 currentFrame = null;
    private ArrayList<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
        if (currentFrame == null || currentFrame.isFinished()) {
            currentFrame = new FrameV4();
            frames.add(currentFrame);
        }
        currentFrame.roll(pins, rolls.size() - 1);
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            score += frames.get(i).score(rolls);
        }
        return score;
    }
}
