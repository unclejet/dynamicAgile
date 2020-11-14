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
    private int gameScore;
    private List<Integer> rolls = new ArrayList<>();

    public int getGameScore() {
        for (int frame = 0; frame < FRAMES_IN_GAME; frame++) {
            int frameScore = rolls.get(frame * 2) + rolls.get(frame * 2 + 1);
            if (frameScore == 10) {
                frameScore += rolls.get(frame * 2 + 2);
            }
            gameScore += frameScore;
        }
        return gameScore;
    }

    public void roll(int pins) {
        rolls.add(pins);
    }
}
