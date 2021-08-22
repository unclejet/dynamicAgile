package com.dynamic.agile.bowling.game.gamescore.v10;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2021/8/21 17:20
 * @description:
 */
public class Game {
    private List<Frame> frames;
    private Frame currentFrame;

    public Game() {
        frames = new ArrayList<>(12);
        currentFrame = new Frame();
        frames.add(currentFrame);
    }

    public void roll(int hitPins) {
        if (currentFrame.isFinished()) { //一轮投完后要启动下一轮进行摆球
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

    private int calScore(Frame curFrame) {
        int curFrameIdx = frames.indexOf(curFrame);
        return curFrame.isMiss() ? calScoreByMissRule(curFrame)
                : curFrame.isSpare() ? calScoreBySpareRule(curFrameIdx)
                : curFrame.isStrike() ? calScoreByStrikeRule(curFrameIdx) : 0;
    }

    private int calScoreByStrikeRule(int curFrameIdx) {
        return hasNextTwoRolls(curFrameIdx) ? Frame.FRAME_MAX_PINS + getNextTwoRollPins(curFrameIdx) : 0;
    }

    private int calScoreBySpareRule(int curFrameIdx) {
        return hasNextRoll(curFrameIdx) ? Frame.FRAME_MAX_PINS + getNextRollPins(getNextFrame(curFrameIdx)) : 0;
    }

    private int calScoreByMissRule(Frame curFrame) {
        return curFrame.getFramePins();
    }

    private int getNextTwoRollPins(int curFrameIdx) {
        Frame nextFrame = getNextFrame(curFrameIdx);
        return nextFrame.isStrike() ?
                Frame.FRAME_MAX_PINS + getNextRollPins(getNextFrame(curFrameIdx + 1))
                : nextFrame.getFramePins();
    }

    private boolean hasNextTwoRolls(int curFrameIdx) {
        if (!hasNextFrame(curFrameIdx)) return false;
        Frame nextFrame = getNextFrame(curFrameIdx);
        return nextFrame.isStrike() ? hasNextRoll(curFrameIdx + 1)
                : nextFrame.isMiss() || nextFrame.isSpare();
    }

    private boolean hasNextRoll(int curFrameIdx) {
        return hasNextFrame(curFrameIdx);
    }

    private boolean hasNextFrame(int curFrameIdx) {
        return frames.size() > curFrameIdx + 1;
    }

    private int getNextRollPins(Frame nextFrame) {
        return nextFrame.getFirstRollPins();
    }

    private Frame getNextFrame(int currentFrameIndex) {
        return frames.get(currentFrameIndex + 1);
    }

    List<Frame> getFrames() {
        return frames;
    }
}
