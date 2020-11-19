package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

class StrikeRule extends ScoreRuleDAPV1 {
    StrikeRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    @Override
    int score() {
        return hasNext2Rolls() ? 10 + nextTwoRollPins() : 0;
    }

    private int nextTwoRollPins() {
        return rolls.get(frameLastRollIndex + 1) + rolls.get(frameLastRollIndex + 2);
    }

    private boolean hasNext2Rolls() {
        return lastRollIndex() >= frameLastRollIndex + 2;
    }

}
