package com.dynamic.agile.bowling.game.gamescore.modeling;

import java.util.ArrayList;
import java.util.List;

import static com.dynamic.agile.bowling.game.gamescore.modeling.Frame.MAX_ROLL_NUMBER_IN_FRAME;
import static com.dynamic.agile.bowling.game.gamescore.modeling.Frame.PINS_IN_FRAME;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 7:37
 * @description:
 */
public class BowlingGame {
    private List<Integer> pins = new ArrayList<>();
    private int rollIndex;

    private List<Frame> frames = new ArrayList<>();

    private int rollIndexOfFrame;


    public int getGameScore() {
        return frames.stream()
                .mapToInt(frame -> frame.calculateScore(pins))
                .sum();
    }

    public void roll(int pins) {
        rollIndexOfFrame++;
        this.pins.add(pins);
        handleFrame();
        rollIndex++;
    }

    private void handleFrame() {
        if (isMiss()) {
            handleMiss();
        } else if (isSpare()) {
            handleSpare();
        } else if (isStrike()) {
            handleStrike();
        }
    }

    private void handleMiss() {
        handleFrameWithTwoRoll(new MissFrame(rollIndex - 1, rollIndex));
    }

    private void handleSpare() {
        handleFrameWithTwoRoll(new SpareFrame(rollIndex - 1, rollIndex));
    }

    private void handleFrameWithTwoRoll(Frame frame) {
        frames.add(frame);
        resetRollIndexOfFrame();
    }

    private void handleStrike() {
        frames.add(new StrikeFrame(rollIndex));
        resetRollIndexOfFrame();
    }

    private void resetRollIndexOfFrame() {
        rollIndexOfFrame = 0;
    }

    private boolean isMiss() {
        return rollIndexOfFrame == MAX_ROLL_NUMBER_IN_FRAME
                && addTwoRollPinsInFrame(rollIndex - 1, this.rollIndex) < PINS_IN_FRAME;
    }

    private boolean isSpare() {
        return rollIndexOfFrame == MAX_ROLL_NUMBER_IN_FRAME
                && addTwoRollPinsInFrame(rollIndex - 1, rollIndex) == PINS_IN_FRAME;
    }

    private boolean isStrike() {
        return rollIndexOfFrame == 1 && pins.get(rollIndex) == PINS_IN_FRAME;
    }

    private int addTwoRollPinsInFrame(int firstRollIndexInFrame, int secondRollIndexInFrame) {
        return pins.get(firstRollIndexInFrame) + pins.get(secondRollIndexInFrame);
    }

    public String getScoreBoard() {
        int frameNumber = getFrameNumber();
        int rollIndexOfFrame = getRollIndexOfFrame();
        String pinsLeft = getPinsLeft();
        int score = getGameScore();
        return String.format("Frame:%d;Roll:%d;Pins Left:%s;Score:%d", frameNumber, rollIndexOfFrame, pinsLeft, score);
    }

    private int getFrameNumber() {
        return frames.size() == 0 ? 1 : frames.size();
    }

    private int getRollIndexOfFrame() {
        if (isFirstRoll()) {
            return 1;
        }
        Frame frame = frames.get(frames.size() - 1);
        return frame.getRollIndexOfFrame(rollIndex - 1);
    }

    private String getPinsLeft() {
        if (isFirstRoll()) {
            return isNoRoll() ? String.valueOf(PINS_IN_FRAME)
                    : String.valueOf(PINS_IN_FRAME - pins.get(0));
        }
        Frame frame = frames.get(frames.size() - 1);
        return frame.getPinsLeft(pins);
    }

    private boolean isNoRoll() {
        return pins.size() == 0;
    }

    private boolean isFirstRoll() {
        return frames.size() == 0;
    }
}
