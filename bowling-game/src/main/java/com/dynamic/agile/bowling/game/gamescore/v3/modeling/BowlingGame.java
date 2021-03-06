package com.dynamic.agile.bowling.game.gamescore.v3.modeling;

import java.util.ArrayList;
import java.util.List;

import static com.dynamic.agile.bowling.game.gamescore.v3.modeling.FrameV3X.*;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 7:37
 * @description:
 */
public class BowlingGame {
    public static final int GAME_FRAMES_NUMBER = 10;
    private List<Integer> pins = new ArrayList<>();
    private int rollIndex;

    private List<FrameV3X> frames = new ArrayList<>();

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
        if (isAdded()) {
            handleAdded();
        } else if (isMiss()) {
            handleMiss();
        } else if (isSpare()) {
            handleSpare();
        } else if (isStrike()) {
            handleStrike();
        }
    }

    private boolean isAdded() {
        return frames.size() == GAME_FRAMES_NUMBER;
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

    private void handleAdded() {
        FrameV3X tenthFrame = getLatestFrame();
        tenthFrame.addAddedRollIndex(rollIndex);
    }

    private void handleMiss() {
        handleFrameWithTwoRoll(new MissFrameV3X(rollIndex - 1, rollIndex));
    }

    private void handleSpare() {
        handleFrameWithTwoRoll(new SpareFrameV3X(rollIndex - 1, rollIndex));
    }

    private void handleFrameWithTwoRoll(FrameV3X frame) {
        frames.add(frame);
        resetRollIndexOfFrame();
    }

    private void handleStrike() {
        frames.add(new StrikeFrameV3X(rollIndex));
        resetRollIndexOfFrame();
    }

    private void resetRollIndexOfFrame() {
        rollIndexOfFrame = 0;
    }

    private int addTwoRollPinsInFrame(int firstRollIndexInFrame, int secondRollIndexInFrame) {
        return pins.get(firstRollIndexInFrame) + pins.get(secondRollIndexInFrame);
    }

    public String getScoreBoard() {
        if (isFirstRoll()) {
            return firstRollScoreBoard();
        } else {
            FrameV3X latestFrame = getLatestFrame();
            return formatScoreBoard(getFrameNumber(latestFrame), getRollIndexOfFrame(latestFrame), getPinsLeft(latestFrame), getGameScore());
        }
    }

    private FrameV3X getLatestFrame() {
        return frames.get(frames.size() - 1);
    }

    private String firstRollScoreBoard() {
        String pinsLeft = isNoRoll() ? String.valueOf(PINS_IN_FRAME)
                : String.valueOf(PINS_IN_FRAME - pins.get(0));
        return formatScoreBoard(1, "1", pinsLeft, 0);
    }

    private boolean isNoRoll() {
        return pins.size() == 0;
    }

    private boolean isFirstRoll() {
        return frames.size() == 0;
    }

    private String formatScoreBoard(int frameNumber, String rollIndexOfFrame, String pinsLeft, int score) {
        return String.format("Frame:%d;Roll:%s;Pins Left:%s;Score:%d", frameNumber, rollIndexOfFrame, pinsLeft, score);
    }

    private int getFrameNumber(FrameV3X latestFrame) {
        int number = isCurrentRollIn(latestFrame) ? frames.size() : frames.size() + 1;
        return number > GAME_FRAMES_NUMBER ? GAME_FRAMES_NUMBER : number;
    }

    private boolean isCurrentRollIn(FrameV3X latestFrame) {
        return latestFrame.contains(rollIndex - 1);
    }

    private String getRollIndexOfFrame(FrameV3X latestFrame) {
        return latestFrame.getRollIndexOfFrame(rollIndex - 1);
    }

    private String getPinsLeft(FrameV3X latestFrame) {
        return isCurrentRollIn(latestFrame) ? latestFrame.getPinsLeft(pins) :
                String.valueOf(PINS_IN_FRAME - pins.get(rollIndex - 1));
    }
}
