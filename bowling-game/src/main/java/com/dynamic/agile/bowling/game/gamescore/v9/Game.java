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
        if (currentFrame.isFinished()) {
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
        return frame.isMiss() ? calMissScore(frame) :
                frame.isSpare() ? calSpareScore(frame) :
                        frame.isStrike() ? calStrikeScore(frame) : 0;
    }

    private int calStrikeScore(Frame frame) {
        return hasNextTwoRolls(getNextFrameIndex(frame)) ?
                Frame.TOTAL_PINS + getNextTwoRollPins(getNextFrameIndex(frame)) : 0;
    }

    private int calSpareScore(Frame frame) {
        return hasNextRoll(getNextFrameIndex(frame)) ?
                Frame.TOTAL_PINS + getNextRollPins(getNextFrameIndex(frame)) : 0;
    }

    private int calMissScore(Frame frame) {
        return frame.getFramePins();
    }

    private int getNextFrameIndex(Frame frame) {
        return frames.indexOf(frame) + 1;
    }

    private int getNextRollPins(int nextFrameIndex) {
        return getNextFrame(nextFrameIndex).getFirstRollPins();
    }

    private Frame getNextFrame(int nextFrameIndex) {
        return frames.get(nextFrameIndex);
    }

    private int getNextTwoRollPins(int nextFrameIndex) {
        Frame nextFrame = getNextFrame(nextFrameIndex);
        return isTwoRollsFrame(nextFrame) ? nextFrame.getFramePins() :
                nextFrame.isStrike() ? Frame.TOTAL_PINS + getNextRollPins(nextFrameIndex + 1) : 0;
    }

    private boolean hasNextTwoRolls(int nextFrameIndex) {
        if (!hasNextFrame(nextFrameIndex)) return false;
        Frame nextFrame = getNextFrame(nextFrameIndex);
        return isTwoRollsFrame(nextFrame) && nextFrame.isFinished()
                || nextFrame.isStrike() && hasNextRoll(nextFrameIndex + 1);
    }

    private boolean isTwoRollsFrame(Frame frame) {
        return frame.isMiss() || frame.isSpare();
    }

    private boolean hasNextRoll(int nextFrameIndex) {
        return hasNextFrame(nextFrameIndex) && getNextFrame(nextFrameIndex).hasFirstRollPins();
    }

    private boolean hasNextFrame(int nextFrameIndex) {
        return frames.size() > nextFrameIndex;
    }
}
