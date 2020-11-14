package com.dynamic.agile.bowling.game.gamescore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UncleJet
 * @date 11/14/2020 9:09 AM
 * @description
 */
public class BowlingGame {
    private int gameScore;
    private List<Integer> rolls = new ArrayList<Integer>();

    public int getGameScore() {
        for (Integer pins : rolls) {
            gameScore += pins;
        }
        return gameScore;
    }

    public void roll(int pins) {
        rolls.add(pins);
    }
}
