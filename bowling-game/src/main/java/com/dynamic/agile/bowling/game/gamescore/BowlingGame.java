package com.dynamic.agile.bowling.game.gamescore;

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
    private int gameScore;
    private List<Integer> rolls = new ArrayList<>();

    public int getGameScore() {
        for (int frame = 0; frame < FRAMES_IN_GAME; frame++) {
            int frameScore = rolls.get(frame * 2) + rolls.get(frame * 2 + 1);
            if (isSpare(frameScore)) {
                frameScore += rolls.get(frame * 2 + 2);
            }
            gameScore += frameScore;
        }
        return gameScore;
    }

    private boolean isSpare(int frameScore) {
        return frameScore == PINS_IN_FRAME;
    }

    public void roll(int pins) {
        rolls.add(pins);
    }
}
