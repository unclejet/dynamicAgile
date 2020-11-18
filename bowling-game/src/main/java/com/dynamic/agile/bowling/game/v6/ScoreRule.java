package com.dynamic.agile.bowling.game.v6;

import java.util.ArrayList;

public abstract class ScoreRule {
    int lastRollIndexOfFrame;
    protected ArrayList<Integer> rolls;
    ScoreRule(ArrayList<Integer> rolls) {
        this.rolls = rolls;
        lastRollIndexOfFrame = getLastRollIndexOfGame();
    }

    int getLastRollIndexOfGame() {
        return rolls.size()-1;
    }

    abstract int score();
}
