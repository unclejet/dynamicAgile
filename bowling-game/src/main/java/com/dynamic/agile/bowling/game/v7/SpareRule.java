package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class SpareRule extends CalRule {
    SpareRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    @Override
    int score() {
        return hasNextRoll() ? FrameV7.PINS_OF_FRAME + rolls.get(nextRollIndex()) : 0;
    }

    private boolean hasNextRoll() {
        return lastRollIndex() >= nextRollIndex();
    }

    private int nextRollIndex() {
        return lastFrameRollIndex + 1;
    }

}
