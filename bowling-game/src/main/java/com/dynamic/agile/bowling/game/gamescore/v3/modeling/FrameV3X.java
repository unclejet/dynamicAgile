package com.dynamic.agile.bowling.game.gamescore.v3.modeling;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 8:57
 * @description:
 */
public abstract class FrameV3X {
    public static final int PINS_IN_FRAME = 10;
    public static final int MAX_ROLL_NUMBER_IN_FRAME = 2;
    public static final int INVALID_ROLL_INDEX = -1;

    protected int firstRollIndex;
    protected int secondRollIndex;
    protected int addedFirstRollIndex;
    protected int addedSecondRollIndex;

    public FrameV3X(int firstRollIndex, int secondRollIndex) {
        this.firstRollIndex = firstRollIndex;
        this.secondRollIndex = secondRollIndex;
        addedFirstRollIndex = INVALID_ROLL_INDEX;
        addedSecondRollIndex = INVALID_ROLL_INDEX;
    }

    public String getRollIndexOfFrame(int currentRollIndex) {
        return currentRollIndex == addedSecondRollIndex ? "added 2" :
                currentRollIndex == addedFirstRollIndex ? "added 1" :
                        currentRollIndex == secondRollIndex ? "2" : "1";
    }

    public void addAddedRollIndex(int rollIndex) {
        if (addedFirstRollIndex == INVALID_ROLL_INDEX) {
            addedFirstRollIndex = rollIndex;
        } else {
            addedSecondRollIndex = rollIndex;
        }
    }

    public boolean contains(int rollIndex) {
        return firstRollIndex == rollIndex
                || secondRollIndex == rollIndex
                || addedFirstRollIndex == rollIndex
                || addedSecondRollIndex == rollIndex;
    }

    public abstract String getPinsLeft(List<Integer> pins);

    public abstract int calculateScore(List<Integer> pins);
}
