package com.dynamic.agile.bowling.game.gamescore.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UncleJet
 * @date 11/14/2020 9:09 AM
 * @description
 */
public class BowlingGame {
    public static final int FRAMES_IN_GAME = 10;
    public static final int PINS_IN_FRAME = 10;
    private List<Integer> rolls = new ArrayList<>();

    public int getGameScore() {
        int gameScore = 0;
        int rollIndexForTheFrame = 0;
        for (int frame = 0; frame < FRAMES_IN_GAME; frame++) {
            int frameScore;
            if (isStrike(rollIndexForTheFrame)) {
                frameScore = PINS_IN_FRAME + getTwoRollsPins(rollIndexForTheFrame + 1);
                rollIndexForTheFrame += 1;
            } else if (isSpare(getTwoRollsPins(rollIndexForTheFrame))) {
                int firstRollInNextFrame = rollIndexForTheFrame + 2;
                frameScore = PINS_IN_FRAME + rolls.get(firstRollInNextFrame);
                rollIndexForTheFrame += 2;
            } else {
                frameScore = getTwoRollsPins(rollIndexForTheFrame);
                rollIndexForTheFrame += 2;
            }
            gameScore += frameScore;

        }
        return gameScore;
    }

    private boolean isSpare(int frameScore) {
        return frameScore == PINS_IN_FRAME;
    }

    private int getTwoRollsPins(int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1);
    }

    private boolean isStrike(int rollIndex) {
        return rolls.get(rollIndex) == PINS_IN_FRAME;
    }

    public void roll(int pins) {
        rolls.add(pins);
    }
}
