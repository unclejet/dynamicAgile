package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

abstract class CalRule {
    int lastFrameRollIndex;
    ArrayList<Integer> rolls;
    CalRule(ArrayList<Integer> rolls) {
        this.rolls = rolls;
        lastFrameRollIndex = lastRollIndex();
    }

    int lastRollIndex() {
        return rolls.size() - 1;
    }

    abstract int score();
}
