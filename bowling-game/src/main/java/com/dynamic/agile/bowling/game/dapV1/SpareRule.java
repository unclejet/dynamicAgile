package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

class SpareRule extends ScoreRuleDAPV1 {
    SpareRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    @Override
    int score() {
        return hasNextRoll() ? FrameDAPV1.PINS_OF_FRAME + nextRollPins() : 0;
    }

    private boolean hasNextRoll() {
        return lastRollIndex() >= nextRollIndex();
    }

    private int nextRollIndex() {
        return frameLastRollIndex + 1;
    }

    private int nextRollPins() {
        return rolls.get(nextRollIndex());
    }
}
