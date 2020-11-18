package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

public class BowlingGameV7 {
    private ArrayList<FrameV7> frames = new ArrayList<>();
    private FrameV7 currentFrame;

    BowlingGameV7() {
        refreshFrame();
    }

    private void refreshFrame() {
        currentFrame = new FrameV7();
        frames.add(currentFrame);
    }

    public void roll(int pins) {
        currentFrame.hitPins(pins);
        if(currentFrame.hasTwoRollPins()){
            refreshFrame();
        }
    }

    public int score() {
        int score = 0;
        for (FrameV7 frame : frames) {
            score += frame.score();
        }
        return score;
    }
}
