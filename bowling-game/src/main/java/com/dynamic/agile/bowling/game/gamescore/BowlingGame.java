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
            int frameScore;
            int firstRollInCurrentFrame = frame * 2;
            int secondRollInCurrentFrame = firstRollInCurrentFrame + 1;
            if (rolls.get(firstRollInCurrentFrame) == 10) { //strike
                frameScore = 10 + rolls.get(firstRollInCurrentFrame + 1) + rolls.get(firstRollInCurrentFrame + 2);
            } else if (isSpare(rolls.get(firstRollInCurrentFrame) + rolls.get(secondRollInCurrentFrame))) {
                int firstRollInNextFrame = firstRollInCurrentFrame + 2;
                frameScore = 10 + rolls.get(firstRollInNextFrame);
            } else {
                frameScore = rolls.get(firstRollInCurrentFrame) + rolls.get(secondRollInCurrentFrame);
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
