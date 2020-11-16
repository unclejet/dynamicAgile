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
        if (isFirstRoll()) {
            return firstRollScoreBoard();
        } else {
            Frame latestFrame = frames.get(frames.size() - 1);
            int frameNumber = getFrameNumber(latestFrame);
            int rollIndexOfFrame = getRollIndexOfFrame(latestFrame);
            String pinsLeft = getPinsLeft(latestFrame);
            int score = getGameScore();
            return formatScoreBoard(frameNumber, rollIndexOfFrame, pinsLeft, score);
        }

    }

    private String firstRollScoreBoard() {
        String pinsLeft = isNoRoll() ? String.valueOf(PINS_IN_FRAME)
                : String.valueOf(PINS_IN_FRAME - pins.get(0));
        return formatScoreBoard(1, 1, pinsLeft, 0);
    }

    private String formatScoreBoard(int frameNumber, int rollIndexOfFrame, String pinsLeft, int score) {
        return String.format("Frame:%d;Roll:%d;Pins Left:%s;Score:%d", frameNumber, rollIndexOfFrame, pinsLeft, score);
    }

    private int getFrameNumber(Frame latestFrame) {
        return isCurrentRollIn(latestFrame) ? frames.size() : frames.size() + 1;

    }

    private boolean isCurrentRollIn(Frame latestFrame) {
        return latestFrame.contains(rollIndex - 1);
    }

    private int getRollIndexOfFrame(Frame latestFrame) {
//        return isCurrentRollIn(latestFrame) ? 2 : 1;
        return latestFrame.getRollIndexOfFrame(rollIndex - 1);
    }

    private String getPinsLeft(Frame latestFrame) {
        return isCurrentRollIn(latestFrame) ? latestFrame.getPinsLeft(pins) :
                String.valueOf(PINS_IN_FRAME - pins.get(rollIndex - 1));
    }

    private boolean isNoRoll() {
        return pins.size() == 0;
    }

    private boolean isFirstRoll() {
        return frames.size() == 0;
    }
}
