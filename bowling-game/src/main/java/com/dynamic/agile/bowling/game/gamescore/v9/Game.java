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
        return frames.stream().mapToInt(frame -> calScore(frame)).sum();
    }

    private int calScore(Frame frame) {
        if (frame.isMiss()) {
            return frame.getFramePins();
        }
        if (frame.isSpare() && hasNextRoll(frame)) {
            return Frame.TOTAL_PINS + frames.get(getNextFrameIndex(frame)).getFirstRollPins();
        }
        return 0;
    }

    private boolean hasNextRoll(Frame frame) {
        return  frames.size() > getNextFrameIndex(frame) ? true : false;
    }

    private int getNextFrameIndex(Frame frame) {
        return frames.indexOf(frame) + 1;
    }
}
