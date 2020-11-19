package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

public class BowlingGameDAPV1 {
    private ArrayList<FrameDAPV1> frames = new ArrayList<>();
    private ArrayList<Integer> rolls = new ArrayList<>();
    private FrameDAPV1 currentFrame;

    BowlingGameDAPV1() {
        createNewFrame();
    }

    private void createNewFrame() {
        currentFrame = new FrameDAPV1();
        frames.add(currentFrame);
    }

    public void roll(int pins) {
        rolls.add(pins);
        currentFrame.hitPins(pins);
        if (currentFrame.isFinished()) {
            currentFrame.setScoreRule(rolls);
            createNewFrame();
        }
    }

    public int score() {
        return frames.stream().mapToInt(FrameDAPV1::score).sum();
    }

    public String scoreBoard() {
        FrameDAPV1 frame = currentFrame;
        int frameIndex = frames.size();
        if (currentFrame.isNew()) {
            frame = frames.get(frames.size() - 2);
            frameIndex = frames.size() - 1;
        }
        return frameIndex + "," + frame.frameRollIndex() + "," + frame.showHitPins() + "," + score();
    }
}
