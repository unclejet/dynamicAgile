package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

abstract class ScoreRule {
    protected ArrayList<Integer> rollPins;
    protected int frameLastRollIndex;
    ScoreRule(ArrayList<Integer> rollPins) {
        this.rollPins = rollPins;
        frameLastRollIndex = lastRollIndex();
    }

    protected int lastRollIndex() {
        return rollPins.size() - 1;
    }

    abstract int score() ;
}
