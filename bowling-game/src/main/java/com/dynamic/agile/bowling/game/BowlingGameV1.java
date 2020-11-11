package com.dynamic.agile.bowling.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/10 18:18
 * @description:
 * @modified By:
 */
public class BowlingGameV1 {
    public static final int FRAME_NUMBER_IN_GAME = 10;
    public static final int ALL_HIT_PINS = 10;
    private List<FrameV1> frames = new ArrayList<>(FRAME_NUMBER_IN_GAME);

    public BowlingGameV1() {
        for (int i = 0; i < FRAME_NUMBER_IN_GAME; i++) {
            frames.add(new FrameV1(i + 1));
        }
    }

    public int statisticScore() {
        frames.stream().forEach(this::calculateScore);
        return frames.stream().mapToInt(FrameV1::getScore).sum();
    }

    private void calculateScore(FrameV1 frame) {
        int score;
        if (frame.isSpare()) {
            score = calculateSpareScore(frame);
        } else if (frame.isStrike()) {
            score = calculateStrikeScore(frame);
        } else {
            score = calculateMissTakeScore(frame);
        }
        frame.setScore(score);
    }

    private int calculateStrikeScore(FrameV1 frame) {
        FrameV1 nextFrame = getNextFrame(frame);
        if (is10thFrame(frame)) {
            return frame.addAddedPins();
        } else if (nextFrame.isStrike()) {
            return ALL_HIT_PINS + getNextRollPins(nextFrame) + getNextRollPins(getNextFrame(nextFrame));
        } else {
            return ALL_HIT_PINS + nextFrame.addPins();
        }
    }

    private int getNextRollPins(FrameV1 nextFrame) {
        if (nextFrame.getIndex() > FRAME_NUMBER_IN_GAME) {
            return frames.get(FRAME_NUMBER_IN_GAME - 1).getFirstAddedRollPins();
        } else {
            return nextFrame.getFirstRollPins();
        }
    }

    private int calculateSpareScore(FrameV1 frame) {
        FrameV1 nextFrame = getNextFrame(frame);
        return is10thFrame(frame) ? frame.addAddedPins() :
                ALL_HIT_PINS + nextFrame.getFirstRollPins();
    }

    private boolean is10thFrame(FrameV1 nextFrame) {
        return nextFrame.getIndex() >= FRAME_NUMBER_IN_GAME;
    }

    private FrameV1 getNextFrame(FrameV1 frame) {
        int index = frame.getIndex();
        return index < FRAME_NUMBER_IN_GAME ? frames.get(index) : new FrameV1(FRAME_NUMBER_IN_GAME + 1);
    }

    private int calculateMissTakeScore(FrameV1 frame) {
        return frame.addPins();
    }

    public Stream<FrameV1> frames() {
        return frames.stream();
    }

    public FrameV1 getSpecialFrame(int index) {
        return isValid(index) ? frames.get(index - 1) : null;
    }

    private boolean isValid(int index) {
        return index >= 1 && index <= FRAME_NUMBER_IN_GAME;
    }
}
