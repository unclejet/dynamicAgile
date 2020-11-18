package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class SpareRule extends CalRule {
    SpareRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    @Override
    int score() {
        return hasNextRoll() ? 10 + rolls.get(lastFrameRollIndex + 1) : 0;
    }

    private boolean hasNextRoll() {
        return lastRollIndex() > lastFrameRollIndex;
    }

}
