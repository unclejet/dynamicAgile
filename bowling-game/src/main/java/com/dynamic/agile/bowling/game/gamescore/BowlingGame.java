package com.dynamic.agile.bowling.game.gamescore;

/**
 * @author UncleJet
 * @date 11/14/2020 9:09 AM
 * @description
 */
public class BowlingGame {
    private int gameScore;
    public int getGameScore() {
        return gameScore;
    }

    public void roll(int pins) {
        gameScore += pins;
    }
}
