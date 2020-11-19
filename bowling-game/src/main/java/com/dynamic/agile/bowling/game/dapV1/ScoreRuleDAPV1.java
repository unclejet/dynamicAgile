package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

abstract class ScoreRuleDAPV1 {
    protected ArrayList<Integer> rolls;
    protected int frameLastRollIndex;
    ScoreRuleDAPV1(ArrayList<Integer> rolls) {
        this.rolls = rolls;
        frameLastRollIndex = lastRollIndex();
    }

    abstract int score();

    protected int lastRollIndex(){
        return rolls.size() - 1;
    }
}
