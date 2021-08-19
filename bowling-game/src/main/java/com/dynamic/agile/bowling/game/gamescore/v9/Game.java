package com.dynamic.agile.bowling.game.gamescore.v9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/8/18 下午12:15
 * @description：
 */
public class Game {
    private List<Frame> frames;
    private Frame currentFrame;

    public Game() {
        frames = new ArrayList<>(12);
        currentFrame = new Frame(); //摆球
        frames.add(currentFrame);
    }

    public void roll(int hitPins) {
        if(currentFrame.isFinished()) {
            startNextFrame();
        }
        currentFrame.record(hitPins);
    }

    private void startNextFrame() {
        currentFrame = new Frame();
        frames.add(currentFrame);
    }

    public int score() {
        return frames.stream().mapToInt(Frame::addPins).sum();
    }
}
